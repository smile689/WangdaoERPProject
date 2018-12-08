package com.cskaoyan.MyTest;

import com.cskaoyan.bean.Device;
import com.cskaoyan.mapper.DeviceMapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

public class MyDeviceTest {

    @Autowired
    DeviceMapper deviceMapper;
    @Test
    public void DeviceTest(){
        String deviceId = "07";
        String deviceName = "冲床";
        String deviceTypeId = "04";
        String deviceStatusId = "4";
        String deviceStatus = "良好";
        Date devicePurchaseDate = new Date();
        BigDecimal devicePurchasePrice = BigDecimal.valueOf(99.94);
        Date deviceManufactureDate = new Date();
        Date deviceServiceLife = new Date();
        String deviceKeeperId = "003";
        String note = "This is Nice!";

        Device device = new Device(deviceId,deviceName, deviceTypeId,
                deviceStatusId,deviceStatus, devicePurchaseDate,
                devicePurchasePrice, deviceManufactureDate,
                deviceServiceLife,deviceKeeperId,note);
        int i = deviceMapper.insert(device);
        System.out.println("device = "+ device);
        System.out.println("insert = "+ i);
    }
}
