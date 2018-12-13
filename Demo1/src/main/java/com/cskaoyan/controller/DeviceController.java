package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    HashMap<String,String> result =new HashMap<>();
    public HashMap<String, String> getResult() {
        return result;
    }
    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

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

    //判断judge
    public HashMap deviceJudge(HttpSession session,String percode){
        List<String> sysPermissionList = (List<String>) session.getAttribute("sysPermissionList");
        boolean flag = false;
        System.out.println("*****************************************************************");
        System.out.println("sysPermissionList = "+sysPermissionList);
        for (String s: sysPermissionList) {
            if(percode.equals(s)){
                flag = true;
                System.out.println(">>>>>>>>>>>>>>>>>>>"+flag+"<<<<<<<<<<<<<<<<<<<<,");
                break;
            }
        }
        if(flag==true){
            return null;
        }else{
            result.put("msg", "您没有权限，请切换用户登录！");
            return result;
        }
    }
}
