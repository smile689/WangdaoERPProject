package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.bean.pojo.EUDataGridResult;
import com.cskaoyan.mapper.DeviceTypeMapper;
import com.cskaoyan.service.DeviceTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper mapper;

    HashMap<String,String> result =new HashMap<>();
    public HashMap<String, String> getResult() {
        return result;
    }
    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    //获得清单
    @Override
    public EUDataGridResult getList(int page, int rows) {
        DeviceType deviceType = new DeviceType();
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceType> list = mapper.selectAll(deviceType);
        System.out.println("DeviceType getList = " +list);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    //查找全部不分页(get_data)
    @Override
    public List<DeviceType> findAll() {
        DeviceType deviceType = new DeviceType();
        List<DeviceType> list = mapper.selectAll(deviceType);
        return list;
    }

    //新增
    @Override
    public HashMap insert(DeviceType deviceType) {
        int i = mapper.insert(deviceType);
        //如果成功
        if(i==1){
            result.put("status","200");
            result.put("msg","OK");
            result.put("data",null);
        }else{
            result.put("status","0");
            result.put("msg","新增失败,请检查！");
            result.put("data",null);
        }
        return result;
    }

    //根据id查(单查)
    @Override
    public DeviceType selectById(String deviceTypeId) {
        DeviceType deviceType = mapper.selectById(deviceTypeId);
        return deviceType;
    }

    //编辑
    @Override
    public HashMap update(DeviceType deviceType) {
        int i = mapper.update(deviceType);
        //如果成功
        if(i==1){
            result.put("status","200");
            result.put("msg","OK");
            result.put("data",null);
        }else{
            result.put("status","0");
            result.put("msg","修改失败,请检查！");
            result.put("data",null);
        }
        return result;
    }

    //批量删除(也可以单删)
    @Override
    public HashMap deleteBatch(String[] deviceTypeIds) {
        int i = mapper.deleteBatch(deviceTypeIds);
        //如果成功
        if(i>0){
            result.put("status","200");
            result.put("msg","OK");
            result.put("data",null);
        }else{
            result.put("status","0");
            result.put("msg","删除失败,请检查，或者减少删除对象！");
            result.put("data",null);
        }
        return result;
    }

    //二例查询
    //根据设备种类编号查找
    @Override
    public EUDataGridResult searchDeviceByDeviceTypeID(int page, int rows, String deviceTypeId) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceType> list = mapper.searchDeviceByDeviceTypeID(deviceTypeId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    //根据设备种类名称查找
    @Override
    public EUDataGridResult searchDeviceByDeviceTypeName(int page, int rows, String deviceTypeName) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceType> list = mapper.searchDeviceByDeviceTypeName(deviceTypeName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
}
