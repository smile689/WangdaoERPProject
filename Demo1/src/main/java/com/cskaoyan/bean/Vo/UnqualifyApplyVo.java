package com.cskaoyan.bean.Vo;

import com.cskaoyan.bean.UnqualityApply;

public class UnqualifyApplyVo extends UnqualityApply {

    private String empName;
    private String productName;

    public UnqualifyApplyVo() {
    }

    public UnqualifyApplyVo(String empName, String productName) {
        this.empName = empName;
        this.productName = productName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "UnqualifyApplyVo{" +
                "empName='" + empName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
