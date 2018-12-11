package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
public class DeviceController {

    //对应 侧边栏的设备台账 device/deviceList
    @RequestMapping("/deviceList")
    public String deviceList() throws Exception{
        return "deviceList";
    }

    //对应 侧边栏的设备种类 device/deviceType
    @RequestMapping("/deviceType")
    public String deviceType() throws Exception{
        return "deviceType";
    }

    //对应 侧边栏的设备例检 device/deviceCheck
    @RequestMapping("/deviceCheck")
    public String deviceCheck() throws Exception{
        return "deviceCheck";
    }

    //对应 侧边栏的设备故障 device/deviceFault
    @RequestMapping("/deviceFault")
    public String deviceFault() throws Exception{
        return "deviceFault";
    }

    //对应 侧边栏的设备维修 device/deviceMaintain
    @RequestMapping("/deviceMaintain")
    public String deviceMaintain() throws Exception{
        return "deviceMaintain";
    }
}
