package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceType;

public interface DeviceTypeMapper {
    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType deviceType);

    int insertSelective(DeviceType deviceType);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType deviceType);

    int updateByPrimaryKey(DeviceType deviceType);
}