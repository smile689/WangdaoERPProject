package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.service.DeviceService;
import com.cskaoyan.utils.JsonChangeRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/deviceList")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    //找到所有device的id和name
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Device> findAll(){
        return deviceService.findAll();
    }

    //根据id找到对应device
    @ResponseBody
    @RequestMapping("/get/{deviceId}")
    public Device getDeviceById(@PathVariable String deviceId){
        return deviceService.findDeviceById(deviceId);
    }

    //修改权限的判断
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map deviceJudge(){
        return null;
    }

    //修改
    @ResponseBody
    @RequestMapping("/update")
    public JsonChangeRet updateProcess(Device device){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        if(deviceService.updateDevice(device)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;

    }
}
