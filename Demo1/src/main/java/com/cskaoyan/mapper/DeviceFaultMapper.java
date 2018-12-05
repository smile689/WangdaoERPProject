package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceFault;

public interface DeviceFaultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault deviceFault);

    int insertSelective(DeviceFault deviceFault);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(DeviceFault deviceFault);

    int updateByPrimaryKey(DeviceFault deviceFault);
}