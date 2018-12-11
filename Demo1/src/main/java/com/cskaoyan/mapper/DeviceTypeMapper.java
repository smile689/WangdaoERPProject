package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {

    //查找全部
    List<DeviceType> selectAll(DeviceType deviceType);
    //新增一例
    int insert(DeviceType deviceType);
    //通过id查
    DeviceType selectById(String deviceTypeId);
    //编辑
    int update(DeviceType deviceType);
    //多选删除(也可以单删)
    int deleteBatch(String[] deviceTypeId);

    //搜索二例
    //根据设备种类编号查找设备信息
    List<DeviceType> searchDeviceByDeviceTypeID(String deviceTypeID);
    //根据设备种类名称查找设备信息
    List<DeviceType> searchDeviceByDeviceTypeName(String deviceTypeName);


    /**
     *逆向工程生成的没有用到的方法
     */
    int deleteByPrimaryKey(String deviceTypeId);
    int insertSelective(DeviceType deviceType);
    int updateByPrimaryKeySelective(DeviceType deviceType);
}