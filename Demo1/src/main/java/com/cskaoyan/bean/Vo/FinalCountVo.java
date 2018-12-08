package com.cskaoyan.bean.Vo;

import com.cskaoyan.bean.FinalCount;

import java.math.BigDecimal;
import java.util.Date;

public class FinalCountVo  extends FinalCount{

    private String emp_Name;

    public FinalCountVo(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public FinalCountVo(String fCountCheckId, String orderId, String checkItem, Integer sample, Integer checkNumber, Integer unqualify, BigDecimal qualify, Date cdate, String measureData, String empId, String result, String note, String emp_Name) {
        super(fCountCheckId, orderId, checkItem, sample, checkNumber, unqualify, qualify, cdate, measureData, empId, result, note);
        this.emp_Name = emp_Name;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }


    @Override
    public String toString() {
        return "FinalCountVo{" +
                "emp_Name='" + emp_Name + '\'' +
                '}';
    }
}
