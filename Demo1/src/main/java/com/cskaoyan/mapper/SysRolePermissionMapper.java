package com.cskaoyan.mapper;

import com.cskaoyan.bean.SysRolePermission;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysRolePermission record);

    SysRolePermission selectByRoleId(String roleId);

    int updateByRoleId(SysRolePermission sysRolePermission);

    int deleteBatchByRoleId(String[] ids);
}