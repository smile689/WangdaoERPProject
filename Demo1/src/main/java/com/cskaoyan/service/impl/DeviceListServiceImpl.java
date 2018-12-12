package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Device;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.mapper.DeviceMapper;
import com.cskaoyan.service.DeviceListService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;


@Service
public class DeviceListServiceImpl implements DeviceListService {

    @Autowired
    DeviceMapper mapper;

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
        Device device = new Device();
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<Device> list = mapper.selectAll(device);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        /*System.out.println("list = "+list);
        System.out.println("pageInfo.getTotal() = "+pageInfo.getTotal());
        System.out.println("Service deviceList方法里的result = "+result);*/
        return result;
    }

    //查找全部不分页(get_data)
    @Override
    public List<Device> findAll() {
        Device device = new Device();
        List<Device> list = mapper.selectAll(device);
        return list;
    }

    //新增
    @Override
    public HashMap insert(@Valid Device device) {
        int i = mapper.insert(device);
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
    public Device selectById(String deviceId) {
        Device device = mapper.selectById(deviceId);
        return device;
    }

    //编辑
    @Override
    public HashMap update(Device device) {
        int i = mapper.update(device);
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
    public HashMap deleteBatch(String[] deviceIds) {
        int i = mapper.deleteBatch(deviceIds);
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

    //三例查询
    @Override
    public JsonFindRet searchDeviceByDeviceId(int page, int rows, String deviceId) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<Device> list = mapper.searchDeviceByDeviceId(deviceId);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public JsonFindRet searchDeviceByDeviceName(int page, int rows, String deviceName) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<Device> list = mapper.searchDeviceByDeviceName(deviceName);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public JsonFindRet searchDeviceByDeviceTypeName(int page, int rows, String deviceTypeName) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<Device> list = mapper.searchDeviceByDeviceTypeName(deviceTypeName);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<Device> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    //修改备注
    @Override
    public HashMap updateNote(Device device) {
        int i = mapper.updateNote(device);
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
