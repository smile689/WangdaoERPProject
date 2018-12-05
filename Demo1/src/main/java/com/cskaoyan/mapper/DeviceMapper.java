package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;

public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device device);

    int insertSelective(Device device);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device device);

    int updateByPrimaryKey(Device device);
}