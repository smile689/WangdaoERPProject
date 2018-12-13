package com.cskaoyan.mapper;

import com.cskaoyan.bean.Device;

import java.util.List;

public interface DeviceMapper {

    //查找全部
    List<Device> selectAll(Device device);
    //新增一例
    int insert(Device device);
    //通过id查
    Device selectById(String deviceId);
    //编辑
    int update(Device device);
    //多选删除(也可以单删)
    int deleteBatch(String[] deviceIds);

    //搜索三例
    //根据设备id查找设备信息
    List<Device> searchDeviceByDeviceId(String deviceId);
    //根据设备名称查找设备信息
    List<Device> searchDeviceByDeviceName(String deviceName);
    //根据设备种类名称查找设备信息
    List<Device> searchDeviceByDeviceTypeName(String deviceTypeName);

    //修改备注(单改)
    int updateNote(Device device);

    /**
     *逆向工程生成的没有用到的方法
     */
    int deleteByPrimaryKey(String deviceId);
    int insertSelective(Device device);
    int updateByPrimaryKeySelective(Device device);
}