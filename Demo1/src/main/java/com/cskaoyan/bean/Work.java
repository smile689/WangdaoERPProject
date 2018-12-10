package com.cskaoyan.bean;

import javax.validation.constraints.Pattern;

/**
 * 作业管理
 */
public class Work {

    @Pattern(regexp = "\\d{3}", message = "作业编号由三位数字组成")
    private String workId;

    private String processNumber;

    //private String productId;

    private Product product;

    //private String processId;

    private Process process;

    //private String deviceId;

    private Device device;

    private Integer rating;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber == null ? null : processNumber.trim();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}