package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceCheck;
import com.cskaoyan.mapper.DeviceCheckMapper;
import com.cskaoyan.service.DeviceCheckService;
import com.cskaoyan.utils.JsonChangeRet;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {

    @Autowired
    DeviceCheckMapper mapper;


    HashMap<String,String> result =new HashMap<>();
    public HashMap<String, String> getResult() {
        return result;
    }
    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    //获得清单
    @Override
    public JsonFindRet getList(int page, int rows) {
        DeviceCheck deviceCheck = new DeviceCheck();
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceCheck> list = mapper.selectAll(deviceCheck);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    //查找全部不分页(get_data)
    @Override
    public List<DeviceCheck> findAll() {
        DeviceCheck deviceCheck = new DeviceCheck();
        List<DeviceCheck> list = mapper.selectAll(deviceCheck);
        return list;
    }


    //新增
    @Override
    public HashMap insert(@Valid DeviceCheck deviceCheck) {
        int i = mapper.insert(deviceCheck);
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
    public DeviceCheck selectById(String deviceCheckId) {
        DeviceCheck deviceCheck = mapper.selectById(deviceCheckId);
        return deviceCheck;
    }

    //编辑
    @Override
    public HashMap update(DeviceCheck deviceCheck) {
        int i = mapper.update(deviceCheck);
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
    public HashMap deleteBatch(String[] deviceCheckIds) {
        int i = mapper.deleteBatch(deviceCheckIds);
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
    @Override
    public JsonFindRet searchDeviceCheckByDeviceCheckId(int page, int rows, String deviceCheckId) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceCheck> list = mapper.searchDeviceCheckByDeviceCheckId(deviceCheckId);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public JsonFindRet searchDeviceCheckByDeviceName(int page, int rows, String deviceName) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceCheck> list = mapper.searchDeviceCheckByDeviceName(deviceName);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    //修改备注
    @Override
    public HashMap updateNote(DeviceCheck deviceCheck) {
        int i = mapper.updateNote(deviceCheck);
        //如果成功
        if(i==1){
            result.put("status","200");
            result.put("msg","OK");
            result.put("data",null);
        }else{
            result.put("status","0");
            result.put("msg","备注修改失败,请检查！");
            result.put("data",null);
        }
        return result;
    }

}
