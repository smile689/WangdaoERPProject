package com.cskaoyan.bean.Vo;

import com.cskaoyan.bean.FinalCount;

import java.math.BigDecimal;
import java.util.Date;

public class FinalCountVo  extends FinalCount{

    private String empName;

    public FinalCountVo() {
    }

    public FinalCountVo(String fCountCheckId, String orderId, String checkItem, Integer sample, Integer checkNumber, Integer unqualify, BigDecimal qualify, Date cdate, String measureData, String empId, String result, String note) {
        super(fCountCheckId, orderId, checkItem, sample, checkNumber, unqualify, qualify, cdate, measureData, empId, result, note);
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "FinalCountVo{" +
                "empName='" + empName + '\'' +
                '}';
    }
}
