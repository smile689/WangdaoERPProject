package com.cskaoyan.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class SysRole {

    @Pattern(regexp = "\\d{3}", message = "角色编号由三位数字组成")
    private String roleId;

    @NotBlank(message = "角色名称不为空")
    private String roleName;

    private String available;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }
}