package com.cskaoyan.service.impl;

import com.cskaoyan.bean.SysRole;
import com.cskaoyan.bean.SysRolePermission;
import com.cskaoyan.bean.vo.UserRoleVO;
import com.cskaoyan.mapper.SysRoleMapper;
import com.cskaoyan.mapper.SysRolePermissionMapper;
import com.cskaoyan.service.SysRoleService;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysRolePermissionMapper sysRolePermissionMapper;

    @Transactional(readOnly = true)
    @Override
    public List<SysRole> findAllRoles() {
        return sysRoleMapper.selectAll();
    }

    @Transactional(readOnly = true)
    @Override
    public JsonFindRet<SysRole> findRolesByPage(SysRole sysRole, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<SysRole> roleList = sysRoleMapper.selectRolesByPage(sysRole);
        PageInfo<SysRole> rolePageInfo=new PageInfo<>(roleList);
        JsonFindRet<SysRole> jsonFindRet=new JsonFindRet<>();
        jsonFindRet.setTotal(rolePageInfo.getTotal());
        jsonFindRet.setRows(roleList);
        return jsonFindRet;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean roleAddJudge(List<String> sysPermissionList) {
        if(sysPermissionList!=null&&!sysPermissionList.isEmpty()){
            for (String str: sysPermissionList) {
                if("role:add".equals(str)){
                    return true;
                }
            }
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public SysRole findRoleById(String roleId) {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    //增加角色，同时增加角色-权限关系表
    @Transactional
    @Override
    public boolean addRole(SysRole sysRole, String permission) {
        SysRolePermission sysRolePermission=new SysRolePermission();
        sysRolePermission.setSysRoleId(sysRole.getRoleId());
        sysRolePermission.setSysPermissionId(permission);
        sysRolePermission.setId(UUID.randomUUID().toString());
        return  ((sysRoleMapper.insert(sysRole)==1)&&(sysRolePermissionMapper.insert(sysRolePermission)==1));
    }

    @Override
    public boolean roleEditJudge(List<String> sysPermissionList) {
        if(sysPermissionList!=null&&!sysPermissionList.isEmpty()){
            for (String str: sysPermissionList) {
                if("role:edit".equals(str)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean updateRole(SysRole sysRole, String permission) {
        SysRolePermission sysRolePermission=new SysRolePermission();
        sysRolePermission.setSysRoleId(sysRole.getRoleId());
        sysRolePermission.setSysPermissionId(permission);
        return ((sysRoleMapper.updateByPrimaryKey(sysRole)==1)&&(sysRolePermissionMapper.updateByRoleId(sysRolePermission)==1));
    }

    @Override
    public boolean roleDeleteJudge(List<String> sysPermissionList) {
        if(sysPermissionList!=null&&!sysPermissionList.isEmpty()){
            for (String str: sysPermissionList) {
                if("role:delete".equals(str)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteRole(String ids) {
        String[] split = ids.split(",");
        if((sysRolePermissionMapper.deleteBatchByRoleId(split)>=1)&&(sysRoleMapper.deleteBatchByKeys(split)>=1)){
            return true;
        }
        return false;
    }
}
