package com.cskaoyan.bean.Vo;

import com.cskaoyan.bean.ProcessMeasure;

public class ProcessMeasuretVo  extends ProcessMeasure{

    private String empName;

    public ProcessMeasuretVo() {
    }

    public ProcessMeasuretVo(String empName) {
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
        return "ProcessMeasuretVo{" +
                "empName='" + empName + '\'' +
                '}';
    }
}
