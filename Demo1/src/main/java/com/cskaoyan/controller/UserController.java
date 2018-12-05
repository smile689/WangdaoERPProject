package com.cskaoyan.controller;


import com.cskaoyan.bean.User;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    @Autowired
    UserService service;

    @RequestMapping("/login")
    public String handlerLogin(String username, String password, HttpSession session){


        User login = service.Login(username, password);

        if (login==null){
            return "/login.jsp";
        }else{
            session.setAttribute("user", login);
            return "/index.jsp";

        }

    }

}
