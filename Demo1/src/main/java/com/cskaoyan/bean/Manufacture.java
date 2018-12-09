package com.cskaoyan.bean;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 生产计划管理
 * --计划进度
 */
public class Manufacture {

    @Pattern(regexp = "\\d{4}", message = "生产批号由四位数字组成")
    private String manufactureSn;

    //private String orderId;

    private Corder cOrder;

    //private String technologyId;

    private Technology technology;

    private Integer launchQuantity;

    private Date beginDate;

    private Date endDate;

    public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn == null ? null : manufactureSn.trim();
    }

    public Corder getcOrder() {
        return cOrder;
    }

    public void setcOrder(Corder cOrder) {
        this.cOrder = cOrder;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public Integer getLaunchQuantity() {
        return launchQuantity;
    }

    public void setLaunchQuantity(Integer launchQuantity) {
        this.launchQuantity = launchQuantity;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}