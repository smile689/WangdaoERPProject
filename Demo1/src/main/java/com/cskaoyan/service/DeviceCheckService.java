package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.bean.pojo.EUDataGridResult;

import java.util.HashMap;
import java.util.List;

public interface DeviceCheckService {
    //查找全部
    EUDataGridResult getList(int page, int rows);
    //查找全部不分页(get_data)
    List<DeviceCheck> findAll();
    //增加
    HashMap insert(DeviceCheck deviceCheck);
    //通过id查
    DeviceCheck selectById(String deviceCheckId);
    //更新
    HashMap update(DeviceCheck deviceCheck);
    //多选删除(也可以单选)
    HashMap deleteBatch(String[] deviceCheckIds);

    //搜索三例
    //根据设备例检编号查找设备例检信息
    EUDataGridResult searchDeviceCheckByDeviceCheckId(int page, int rows, String deviceCheckId);
    //根据设备名称查找设备例检信息
    EUDataGridResult searchDeviceCheckByDeviceName(int page, int rows, String deviceName);

    //编辑备注
    public HashMap updateNote(DeviceCheck deviceCheck);
}
