package com.cskaoyan.service;

import com.cskaoyan.bean.Device;

import java.util.List;

public interface DeviceService {

    List<Device> findAll();

    Device findDeviceById(String deviceId);

    boolean updateDevice(Device device);
}
