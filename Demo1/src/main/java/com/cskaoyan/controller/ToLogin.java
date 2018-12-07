package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/7 17:00
 * @需求:
 * @思路说明:
 */
@Controller
public class ToLogin {
    @RequestMapping(value = "/{formName}")
    public String toLogin(@PathVariable String formName){
        return formName;
    }
}
