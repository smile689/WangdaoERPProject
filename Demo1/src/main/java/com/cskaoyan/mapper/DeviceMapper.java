package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;

import java.util.List;

public interface DeviceMapper {
    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    List<Device> selectAll();
}