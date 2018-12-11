package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceCheck;

import java.util.List;

public interface DeviceCheckMapper {

    //查找全部
    List<DeviceCheck> selectAll(DeviceCheck deviceCheck);
    //新增一例
    int insert(DeviceCheck deviceCheck);
    //通过id查
    DeviceCheck selectById(String deviceCheckId);
    //编辑
    int update(DeviceCheck deviceCheck);
    //多选删除(也可以单删)
    int deleteBatch(String[] deviceCheckIds);

    //搜索二例
    //根据设备例检编号查找设备例检信息
    List<DeviceCheck> searchDeviceCheckByDeviceCheckId(String deviceCheckId);
    //根据设备名称查找设备例检信息
    List<DeviceCheck> searchDeviceCheckByDeviceName(String deviceName);

    //修改备注(单改)
    int updateNote(DeviceCheck deviceCheck);

    /**
     *逆向工程生成的没有用到的方法
     */
    int deleteByPrimaryKey(String deviceCheckId);
    int insertSelective(DeviceCheck deviceCheck);
    int updateByPrimaryKeySelective(DeviceCheck deviceCheck);
}