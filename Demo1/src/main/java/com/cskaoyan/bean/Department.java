package com.cskaoyan.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.List;

public class Department {

    @Pattern(regexp = "[0-9]+",message = "部门编号请使用纯数字！")
    private String departmentId;

    @Pattern(regexp = "[A-Za-z0-9\\u4e00-\\u9fa5]+部",message = "部门名称请使用中文或大小写字母，格式：xx部！")
    private String departmentName;

    @NotBlank(message = "部门职责不能为空或空字符串！")
    private String note;

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}