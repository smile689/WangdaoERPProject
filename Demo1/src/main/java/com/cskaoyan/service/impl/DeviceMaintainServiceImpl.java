package com.cskaoyan.service.impl;

import com.cskaoyan.bean.DeviceMaintain;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.mapper.DeviceMaintainMapper;
import com.cskaoyan.service.DeviceMaintainService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

    @Autowired
    DeviceMaintainMapper mapper;

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
        DeviceMaintain deviceMaintain = new DeviceMaintain();
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceMaintain> list = mapper.selectAll(deviceMaintain);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    //查找全部不分页(get_data)
    @Override
    public List<DeviceMaintain> findAll() {
        DeviceMaintain deviceMaintain = new DeviceMaintain();
        List<DeviceMaintain> list = mapper.selectAll(deviceMaintain);
        return list;
    }


    //新增
    @Override
    public HashMap insert(@Valid DeviceMaintain deviceMaintain) {
        int i = mapper.insert(deviceMaintain);
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
    public DeviceMaintain selectById(String deviceMaintainId) {
        DeviceMaintain deviceMaintain = mapper.selectById(deviceMaintainId);
        return deviceMaintain;
    }

    //编辑
    @Override
    public HashMap update(DeviceMaintain deviceMaintain) {
        int i = mapper.update(deviceMaintain);
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
    public HashMap deleteBatch(String[] deviceMaintainIds) {
        int i = mapper.deleteBatch(deviceMaintainIds);
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
    public JsonFindRet searchDeviceMaintainByDeviceMaintainId(int page, int rows, String deviceMaintainId) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceMaintain> list = mapper.searchDeviceMaintainByDeviceMaintainId(deviceMaintainId);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public JsonFindRet searchDeviceMaintainByDeviceFaultId(int page, int rows, String deviceFaultId) {
        //分页处理
        PageHelper.startPage(page, rows);
        //查询列表
        List<DeviceMaintain> list = mapper.searchDeviceMaintainByDeviceFaultId(deviceFaultId);
        //创建一个返回值对象
        JsonFindRet result = new JsonFindRet();
        //几条具体信息 放入result
        result.setRows(list);
        //取记录信息总条数 放入result
        PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }
    //修改备注
    @Override
    public HashMap updateNote(DeviceMaintain deviceMaintain) {
        int i = mapper.updateNote(deviceMaintain);
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
