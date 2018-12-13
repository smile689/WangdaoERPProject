package com.cskaoyan.controller;


import com.cskaoyan.bean.SysUser;
import com.cskaoyan.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
public class AjaxLoginController {

    @Autowired
    SysUserService sysUserService;

    //登录处理
    //尝试用shiro
    @ResponseBody
    @RequestMapping("/ajaxLogin")
    public Map login(String username, String password, String randomcode, HttpSession session){
        Map<String, String> map=new HashMap<>();
        if(randomcode!=null){
            String validateCode = (String) session.getAttribute("validateCode");
            if(!validateCode.equals(randomcode)){
                map.put("msg", "randomcode_error");
                return map;
            }
        }
        //没有授权的意思？
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isAuthenticated()){
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            try{
                subject.login(usernamePasswordToken);
            }catch (UnknownAccountException e){
                map.put("msg", "account_error");
                return map;
            }catch (IncorrectCredentialsException e){
                map.put("msg", "password_error");
                return map;
            }catch (AuthenticationException e){
                map.put("msg", "authentication_error");
                return map;
            }
        }
        return map;
    }

    //退出登录
    //用shiro实现
    /*@RequestMapping("/logout")
    public String logout(HttpSession session, Model model){
        session.invalidate();
        return "login";
    }*/
}
