package com.cskaoyan.service;

import com.cskaoyan.bean.SysUser;

public interface SysUserService {

    SysUser findSysUserByUsername(String username);
}
