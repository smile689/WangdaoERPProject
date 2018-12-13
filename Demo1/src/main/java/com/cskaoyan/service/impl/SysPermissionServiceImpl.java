package com.cskaoyan.service.impl;

import com.cskaoyan.bean.SysRolePermission;
import com.cskaoyan.mapper.SysRolePermissionMapper;
import com.cskaoyan.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public SysRolePermission findPermissionByRoleId(String roleId) {
        return sysRolePermissionMapper.selectByRoleId(roleId);
    }

    @Override
    public boolean updatePermissionByRoleId(SysRolePermission sysRolePermission) {
        return sysRolePermissionMapper.updateByRoleId(sysRolePermission)==1;
    }
}
