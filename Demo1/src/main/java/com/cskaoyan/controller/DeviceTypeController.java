package com.cskaoyan.controller;


import com.cskaoyan.bean.DeviceType;
import com.cskaoyan.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    //获得所有的deviceType
    @ResponseBody
    @RequestMapping("/get_data")
    public List<DeviceType> findAll(){
        return deviceTypeService.findAll();
    }
}
