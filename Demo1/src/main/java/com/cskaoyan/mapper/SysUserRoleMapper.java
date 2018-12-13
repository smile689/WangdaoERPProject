package com.cskaoyan.mapper;

import com.cskaoyan.bean.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUserRole record);

    SysUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysUserRole record);

    int updateByUserId(SysUserRole sysUserRole);

    int deleteBatchByUserId(String[] split);
}