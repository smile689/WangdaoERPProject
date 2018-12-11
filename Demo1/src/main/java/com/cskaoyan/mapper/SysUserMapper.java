package com.cskaoyan.mapper;

import com.cskaoyan.bean.SysUser;

public interface SysUserMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUsername(String username);
}