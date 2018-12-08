package com.cskaoyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/work")
public class WorkController {


    @RequestMapping("/find")
    public String findWorkListJsp(){
        return "work_list";
    }


}
