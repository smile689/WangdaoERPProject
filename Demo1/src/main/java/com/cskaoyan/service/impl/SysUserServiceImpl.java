package com.cskaoyan.service.impl;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.bean.SysUserRole;
import com.cskaoyan.bean.vo.UserRoleVO;
import com.cskaoyan.mapper.SysPermissionMapper;
import com.cskaoyan.mapper.SysUserMapper;
import com.cskaoyan.mapper.SysUserRoleMapper;
import com.cskaoyan.service.SysUserService;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysPermissionMapper sysPermissionMapper;

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Transactional(readOnly = true)
    @Override
    public SysUser findSysUserByUsername(String username) {
        return sysUserMapper.selectByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public UserRoleVO findActiveUserByUsername(String username) {
        return sysUserMapper.selectActiveUserByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public JsonFindRet<UserRoleVO> findUserWithRoleByPage(UserRoleVO userRoleVO, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<UserRoleVO> userRoleList = sysUserMapper.selectAllUserWithRole(userRoleVO);
        PageInfo<UserRoleVO> userRolePageInfo=new PageInfo<>(userRoleList);
        JsonFindRet<UserRoleVO> jsonFindRet=new JsonFindRet<>();
        jsonFindRet.setTotal(userRolePageInfo.getTotal());
        jsonFindRet.setRows(userRoleList);
        return jsonFindRet;
    }

    //找到用户对应的所有许可
    @Transactional(readOnly = true)
    @Override
    public List<String> findPermissionsByUsername(String username) {
        String permissionString = sysUserMapper.queryPermissionsByUsername(username);
        if(permissionString!=null){
            String[] split = permissionString.split(",");
            List<String> permissions = sysPermissionMapper.selectPermissionsByIdArray(split);
            return permissions;
        }
        return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    @Override
    public SysUser findUserById(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    //判断用户是否有添加该表的权限
    @Transactional(readOnly = true)
    @Override
    public boolean userAddJudge(UserRoleVO userRoleVO) {
        List<String> permissionsByUsername = findPermissionsByUsername(userRoleVO.getUsername());
        if(permissionsByUsername!=null&&permissionsByUsername.size()!=0){
            for (String p: permissionsByUsername) {
                if("user:add".equals(p)){
                    return true;
                }
            }
        }
        return false;
    }

    //处理用户添加，还要处理用户角色关系表
    //回滚条件
    @Transactional
    @Override
    public boolean addUser(UserRoleVO userRoleVO) {
        SysUserRole sysUserRole=new SysUserRole();
        sysUserRole.setSysUserId(userRoleVO.getId());
        sysUserRole.setSysRoleId(userRoleVO.getRoleId());
        sysUserRole.setId(UUID.randomUUID().toString());
        if((sysUserMapper.insert(userRoleVO)==1)&&(sysUserRoleMapper.insert(sysUserRole)==1)){
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean userEditJudge(UserRoleVO activeUser) {
        List<String> permissionsByUsername = findPermissionsByUsername(activeUser.getUsername());
        if(permissionsByUsername!=null&&permissionsByUsername.size()!=0){
            for (String p: permissionsByUsername) {
                if("user:edit".equals(p)){
                    return true;
                }
            }
        }
        return false;
    }

    @Transactional
    @Override
    public boolean updateUser(UserRoleVO userRoleVO) {
        SysUserRole sysUserRole=new SysUserRole();
        sysUserRole.setSysUserId(userRoleVO.getId());
        sysUserRole.setSysRoleId(userRoleVO.getRoleId());
        if((sysUserMapper.updateByPrimaryKey(userRoleVO)==1)&&(sysUserRoleMapper.updateByUserId(sysUserRole)==1)){
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean userDeleteJudge(UserRoleVO activeUser) {
        List<String> permissionsByUsername = findPermissionsByUsername(activeUser.getUsername());
        if(permissionsByUsername!=null&&permissionsByUsername.size()!=0){
            for (String p: permissionsByUsername) {
                if("user:delete".equals(p)){
                    return true;
                }
            }
        }
        return false;
    }

    //删除用户，还要删除对应的关系
    @Transactional
    @Override
    public boolean deleteUser(String ids) {
        String[] split = ids.split(",");
        if((sysUserRoleMapper.deleteBatchByUserId(split)>=1)&&(sysUserMapper.deleteBatchByKeys(split)>=1)){
            return true;
        }
        return false;
    }
}
