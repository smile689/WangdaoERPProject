package com.cskaoyan.service;

import com.cskaoyan.bean.DeviceFault;
import com.cskaoyan.utils.JsonFindRet;

import java.util.HashMap;
import java.util.List;

public interface DeviceFaultService {
    //查找全部
    JsonFindRet getList(int page, int rows);
    //查找全部不分页(get_data)
    List<DeviceFault> findAll();
    //增加
    HashMap insert(DeviceFault deviceFault);
    //通过id查
    DeviceFault selectById(String deviceFaultId);
    //更新
    HashMap update(DeviceFault deviceFault);
    //多选删除(也可以单选)
    HashMap deleteBatch(String[] deviceFaultIds);

    //搜索三例
    //根据设备例检编号查找设备例检信息
    JsonFindRet searchDeviceFaultByDeviceFaultId(int page, int rows, String deviceFaultId);
    //根据设备名称查找设备例检信息
    JsonFindRet searchDeviceFaultByDeviceName(int page, int rows, String deviceName);

    //编辑备注
    public HashMap updateNote(DeviceFault deviceFault);
}
