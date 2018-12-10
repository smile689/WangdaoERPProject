package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceMaintain;

public interface DeviceMaintainMapper {
    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain deviceMaintain);

    int insertSelective(DeviceMaintain deviceMaintain);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain deviceMaintain);

    int updateByPrimaryKey(DeviceMaintain deviceMaintain);
}