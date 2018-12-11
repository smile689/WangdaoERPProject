package com.cskaoyan.bean.vo;

import com.cskaoyan.bean.DeviceCheck;

public class DeviceCheckVO extends DeviceCheck {
    //比DeviceCheck多出的成员变量
    private String deviceName;
    private String deviceCheckEmp;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCheckEmp() {
        return deviceCheckEmp;
    }

    public void setDeviceCheckEmp(String deviceCheckEmp) {
        this.deviceCheckEmp = deviceCheckEmp;
    }
}
