package com.cskaoyan.bean.vo;

import com.cskaoyan.bean.FinalMeasuret;

public class FinalMeasuretVo extends FinalMeasuret {

    private String empName;

    public FinalMeasuretVo() {
    }

    public FinalMeasuretVo(String empName) {
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
        return "FinalMeasuretVo{" +
                "empName='" + empName + '\'' +
                '}';
    }
}
