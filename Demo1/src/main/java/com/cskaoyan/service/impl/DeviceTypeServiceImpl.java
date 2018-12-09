package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;

    @Override
    public List<DeviceType> findAll() {
        return deviceTypeMapper.selectAll();
    }
}
