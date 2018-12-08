package com.cskaoyan.controller;

import com.cskaoyan.bean.Corder;
import com.cskaoyan.service.CorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class CorderController {

    @Autowired
    CorderService corderService;

    //点击对应标签后跳转到list的jsp
    @RequestMapping("/find")
    public String findOrderListJsp(){
        return "order_list";
    }

    @ResponseBody
    @RequestMapping("/list")
    public Map findOrders(String page, String rows){
        List<Corder> corders= corderService.findOrders(page, rows);
        Integer totalNum = corderService.countTotalNum();
        Map<String, Object> map=new HashMap<>();
        map.put("total", totalNum);
        map.put("rows", corders);
        System.out.println(map);
        return map;
    }




}
