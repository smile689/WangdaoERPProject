package com.cskaoyan.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class SysUser {

    @Pattern(regexp = "\\d{3}", message = "用户编号由三位数字组成")
    private String id;

    @NotBlank(message = "用户名称不为空")
    private String username;

    @NotBlank(message = "用户密码不为空")
    private String password;

    private String locked;

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", locked='" + locked + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked == null ? null : locked.trim();
    }
}