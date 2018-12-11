package com.cskaoyan.bean;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class Employee {

    @Pattern(regexp = "[0-9]+",message = "员工编号请使用纯数字！")
    private String empId;

    @Pattern(regexp = "[\\u4e00-\\u9fa5]{2,}",message = "员工姓名请输入至少两个纯中文字符！")
    private String empName;

    private String sex;

    @Pattern(regexp = "([0-9]{17}([0-9]|x){1})?", message = "身份证号留空或使用格式：18位纯数字或17位纯数字加字母x！")
    private String idCode;

    private Date birthday;

    private Date joinDate;

    @Pattern(regexp = "((在职)|(离职))?", message = "员工状态请输入‘在职’、‘离职’或留空！")
    private String status;

    @Pattern(regexp = "((专科)|(本科)|(硕士研究生)|(博士研究生))?", message = "学历请输入‘专科’、‘本科’、‘硕士研究生’、‘博士研究生’或留空！")
    private String education;

    @Pattern(regexp = "((学士)|(硕士)|(博士))?", message = "学位请输入‘学士’、‘硕士’、‘博士’或留空！")
    private String degree;

    @Pattern(regexp = "[\\u4e00-\\u9fa5]*",message = "专业请使用中文或留空！")
    private String major;

    @Pattern(regexp = "([A-Za-z]*)|([\\u4e00-\\u9fa5]*)",message = "毕业学校请使用中文、大小写字母或留空！")
    private String graduateSchool;

    @Pattern(regexp = "((全日制)|(在职))?", message = "学历请输入‘全日制’、‘在职’或留空！")
    private String educationForm;

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool == null ? null : graduateSchool.trim();
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm == null ? null : educationForm.trim();
    }
}