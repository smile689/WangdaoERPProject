package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.utils.JsonFindRet;

import java.util.HashMap;
import java.util.List;

public interface DeviceMaintainService {
    //查找全部
    JsonFindRet getList(int page, int rows);
    //查找全部不分页(get_data)
    List<DeviceMaintain> findAll();
    //增加
    HashMap insert(DeviceMaintain deviceMaintain);
    //通过id查
    DeviceMaintain selectById(String deviceMaintainId);
    //更新
    HashMap update(DeviceMaintain deviceMaintain);
    //多选删除(也可以单选)
    HashMap deleteBatch(String[] deviceMaintainIds);

    //搜索二例
    //根据设备例检编号查找设备例检信息 search_deviceMaintain_by_deviceMaintainId
    JsonFindRet searchDeviceMaintainByDeviceMaintainId(int page, int rows, String deviceMaintainId);
    //根据设备故障编号查找设备例检信息 search_deviceMaintain_by_deviceFaultId
    JsonFindRet searchDeviceMaintainByDeviceFaultId(int page, int rows, String deviceFaultId);

    //编辑备注
    public HashMap updateNote(DeviceMaintain deviceMaintain);
}
