package com.cskaoyan.service;

import com.cskaoyan.bean.SysRole;
import com.cskaoyan.bean.vo.UserRoleVO;
import com.cskaoyan.utils.JsonFindRet;

import java.util.List;

/**
 * 角色
 */
public interface SysRoleService {

    List<SysRole> findAllRoles();

    JsonFindRet<SysRole> findRolesByPage(SysRole sysRole, Integer page, Integer rows);

    boolean roleAddJudge(List<String> sysPermissionList);

    SysRole findRoleById(String roleId);

    boolean addRole(SysRole sysRole, String permission);

    boolean roleEditJudge(List<String> sysPermissionList);

    boolean updateRole(SysRole sysRole, String permission);

    boolean roleDeleteJudge(List<String> sysPermissionList);

    boolean deleteRole(String ids);
}
