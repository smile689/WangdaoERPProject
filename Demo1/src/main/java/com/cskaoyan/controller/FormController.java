package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class FormController {

    //动态页面跳转
    @RequestMapping(value = "/{formName}")
    public String toLogin(@PathVariable String formName, HttpSession session){
        return formName;
    }
}
