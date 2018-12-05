package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceCheck;

public interface DeviceCheckMapper {
    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck deviceCheck);

    int insertSelective(DeviceCheck deviceCheck);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck deviceCheck);

    int updateByPrimaryKey(DeviceCheck deviceCheck);
}