package com.cskaoyan.bean.vo;

import com.cskaoyan.bean.ProcessCount;

public class ProcessCountVo extends ProcessCount {
    private String empName;

    public ProcessCountVo() {
    }

    public ProcessCountVo(String empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "ProcessCountVo{" +
                "empName='" + empName + '\'' +
                '}';
    }
}
