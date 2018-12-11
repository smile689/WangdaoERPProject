package com.cskaoyan.mapper;

import com.cskaoyan.bean.DeviceMaintain;

import java.util.List;

public interface DeviceMaintainMapper {
    //查找全部
    List<DeviceMaintain> selectAll(DeviceMaintain deviceMaintain);
    //新增一例
    int insert(DeviceMaintain deviceMaintain);
    //通过id查
    DeviceMaintain selectById(String deviceMaintainId);
    //编辑
    int update(DeviceMaintain deviceMaintain);
    //多选删除(也可以单删)
    int deleteBatch(String[] deviceMaintainIds);

    //搜索二例
    //根据设备例检编号查找设备例检信息 search_deviceMaintain_by_deviceMaintainId
    List<DeviceMaintain> searchDeviceMaintainByDeviceMaintainId(String deviceMaintainId);
    //根据设备故障编号查找设备例检信息 search_deviceMaintain_by_deviceFaultId
    List<DeviceMaintain> searchDeviceMaintainByDeviceFaultId(String deviceName);

    //修改备注(单改)
    int updateNote(DeviceMaintain deviceMaintain);

    /**
     *逆向工程生成的没有用到的方法
     */
    int deleteByPrimaryKey(String deviceMaintainId);
    int insertSelective(DeviceMaintain deviceMaintain);
    int updateByPrimaryKeySelective(DeviceMaintain deviceMaintain);
}