package com.cskaoyan.controller;

import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {


    @Autowired
    TechnologyPlanService technologyPlanService;

    //找到所有信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<TechnologyPlan> findAll(){
        return technologyPlanService.findAll();
    }
}
