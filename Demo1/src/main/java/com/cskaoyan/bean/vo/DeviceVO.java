package com.cskaoyan.bean.vo;

import com.cskaoyan.bean.Device;
import org.springframework.stereotype.Repository;

@Repository
public class DeviceVO extends Device {

    //比Device多出的成员变量
    private String deviceTypeName;
    private String deviceKeeper;

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceKeeper() {
        return deviceKeeper;
    }

    public void setDeviceKeeper(String deviceKeeper) {
        this.deviceKeeper = deviceKeeper;
    }
}
