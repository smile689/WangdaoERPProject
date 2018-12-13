package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.utils.JsonFindRet;

import java.util.HashMap;
import java.util.List;

public interface DeviceTypeService {

    //查找全部
    JsonFindRet getList(int page, int rows);
    //查找全部不分页(get_data)
    List<DeviceType> findAll();
    //增加
    HashMap insert(DeviceType deviceType);
    //通过id查
    DeviceType selectById(String deviceTypeId);
    //更新
    HashMap update(DeviceType deviceType);
    //多选删除(也可以单选)
    HashMap deleteBatch(String[] deviceTypeIds);

    //搜索二例
    //根据设备种类编号查找
    JsonFindRet searchDeviceByDeviceTypeID(int page, int rows, String deviceTypeId);
    //根据设备种类名称查找
    JsonFindRet searchDeviceByDeviceTypeName(int page, int rows, String deviceTypeName);

}
