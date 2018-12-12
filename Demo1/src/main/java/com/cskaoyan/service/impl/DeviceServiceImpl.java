package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public List<Device> findAll() {
        return deviceMapper.selectAll();
    }

    @Override
    public Device findDeviceById(String deviceId) {
        return deviceMapper.selectByPrimaryKey(deviceId);
    }

    @Override
    public boolean updateDevice(Device device) {
        return deviceMapper.updateByPrimaryKey(device)==1;
    }
}
