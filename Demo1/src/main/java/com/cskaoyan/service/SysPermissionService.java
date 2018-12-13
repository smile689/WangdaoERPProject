package com.cskaoyan.service;


import com.cskaoyan.bean.SysRolePermission;
import org.springframework.stereotype.Service;

/**
 * 处理权限
 */
public interface SysPermissionService {


    SysRolePermission findPermissionByRoleId(String roleId);

    boolean updatePermissionByRoleId(SysRolePermission sysRolePermission);
}
