package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceFault;

import java.util.List;

public interface DeviceFaultMapper {

    //查找全部
    List<DeviceFault> selectAll(DeviceFault deviceFault);
    //新增一例
    int insert(DeviceFault deviceFault);
    //通过id查
    DeviceFault selectById(String deviceFaultId);
    //编辑
    int update(DeviceFault deviceFault);
    //多选删除(也可以单删)
    int deleteBatch(String[] deviceFaultIds);

    //搜索二例
    //根据故障编号查找设备故障信息
    List<DeviceFault> searchDeviceFaultByDeviceFaultId(String deviceFaultId);
    //根据设备名称查找设备故障信息
    List<DeviceFault> searchDeviceFaultByDeviceName(String deviceName);

    //修改备注(单改)
    int updateNote(DeviceFault deviceFault);

    /**
     *逆向工程生成的没有用到的方法
     */
    int deleteByPrimaryKey(String deviceFaultId);
    int insertSelective(DeviceFault deviceFault);
    int updateByPrimaryKeySelective(DeviceFault deviceFault);
}