package com.cskaoyan.service;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.bean.vo.UserRoleVO;
import com.cskaoyan.utils.JsonFindRet;

import java.util.List;

public interface SysUserService {

    SysUser findSysUserByUsername(String username);

    UserRoleVO findActiveUserByUsername(String username);

    //List<UserRoleVO> findAllUserWithRole();

    JsonFindRet<UserRoleVO> findUserWithRoleByPage(UserRoleVO userRoleVO, Integer page, Integer rows);

    List<String> findPermissionsByUsername(String username);

    SysUser findUserById(String id);

    boolean userAddJudge(UserRoleVO userRoleVO);

    boolean addUser(UserRoleVO userRoleVO);

    boolean userEditJudge(UserRoleVO activeUser);

    boolean updateUser(UserRoleVO userRoleVO);

    boolean userDeleteJudge(UserRoleVO activeUser);

    boolean deleteUser(String ids);
}
