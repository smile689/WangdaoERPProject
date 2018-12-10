package com.cskaoyan.service;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.pojo.EUDataGridResult;

import java.util.HashMap;
import java.util.List;


public interface DeviceListService {

    //查找全部
    EUDataGridResult getList(int page, int rows);
    //查找全部不分页(get_data)
    List<Device> findAll();
    //增加
    HashMap insert(Device device);
    //通过id查
    Device selectById(String deviceId);
    //更新
    HashMap update(Device device);
    //多选删除(也可以单选)
    HashMap deleteBatch(String[] deviceIds);

    //搜索三例
    //根据设备id查找设备信息
    EUDataGridResult searchDeviceByDeviceId(int page, int rows, String deviceId);
    //根据设备名称查找设备信息
    EUDataGridResult searchDeviceByDeviceName(int page, int rows, String deviceName);
    //根据设备种类名称查找设备信息
    EUDataGridResult searchDeviceByDeviceTypeName(int page, int rows, String deviceTypeName);

    //编辑备注
    public HashMap updateNote(Device device);


}
