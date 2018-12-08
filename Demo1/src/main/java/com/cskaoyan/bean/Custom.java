package com.cskaoyan.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * 客户管理
 */
public class Custom {

    @Pattern(regexp = "\\d{3}", message = "客户编号由三位数字组成")
    private String customId;

    @NotBlank(message = "客户名称不为空")
    private String customName;

    @NotBlank(message = "客户全称不为空")
    private String fullName;

    private String address;

    private String fax;

    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "经理姓名不为空")
    private String ownerName;

    @Pattern(regexp = "(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}", message = "手机号码格式不正确")
    private String ownerTel;

    private Integer status;

    private String note;

    @Override
    public String toString() {
        return "Custom{" +
                "customId='" + customId + '\'' +
                ", customName='" + customName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", ownerTel='" + ownerTel + '\'' +
                ", status=" + status +
                ", note='" + note + '\'' +
                '}';
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId == null ? null : customId.trim();
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel == null ? null : ownerTel.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}