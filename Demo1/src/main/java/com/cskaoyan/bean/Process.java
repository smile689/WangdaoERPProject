package com.cskaoyan.bean;

import javax.validation.constraints.Pattern;

public class Process {

    @Pattern(regexp = "[0-5]{3}",message = "工序编号由三位组成，且为正数")

    private String processId;
    @Pattern(regexp = "[0-5]{3}",message = "工艺计划编号由三位组成，且为正数")

    private String technologyPlanId;

    private Integer sequence;

    private Integer quota;


    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }
}