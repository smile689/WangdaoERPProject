package com.cskaoyan.controller;


import com.cskaoyan.bean.SysUser;
import com.cskaoyan.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//处理用户登录
@Controller
public class UserController {

    @Autowired
    SysUserService sysUserService;

    //登录处理
    @ResponseBody
    @RequestMapping("/ajaxLogin")
    public Map login(String username, String password, String randomcode, HttpSession session){
        Map<String, String> map=new HashMap<>();
        SysUser sysUserByUsername = sysUserService.findSysUserByUsername(username);
        if(sysUserByUsername==null){
            map.put("msg", "account_error");
            return map;
        }
        if(!password.equals(sysUserByUsername.getPassword())){
            map.put("msg", "password_error");
            return map;
        }
        if(!"0".equals(sysUserByUsername.getLocked())){
            map.put("msg", "authentication_error");
            return map;
        }
        if(randomcode!=null){
            String validateCode = (String) session.getAttribute("validateCode");
            if(!validateCode.equals(randomcode)){
                map.put("msg", "randomcode_error");
                return map;
            }
        }
        session.setAttribute("activeUser", sysUserByUsername);
        return map;
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();
        return "login";
    }
}
