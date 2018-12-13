package com.cskaoyan.bean.vo;

import com.cskaoyan.bean.SysUser;

/**
 * 施巍啸
 * 存储当前登陆的用户信息
 */
public class UserRoleVO extends SysUser {

    private String roleId;

    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
