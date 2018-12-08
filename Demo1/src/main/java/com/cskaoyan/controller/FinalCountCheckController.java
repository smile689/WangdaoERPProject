package com.cskaoyan.controller;

import com.cskaoyan.bean.EUDateGridResult;
import com.cskaoyan.service.FinalCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FinalCountCheckController {

    @Autowired
    //将 成品计数的对象  注入
    FinalCountCheckService finalCountCheckService;
    //由home.jsp 点击 转向详情页
    @RequestMapping("/f_count_check/find")
    public String tofcountcheck()
    {
        return "/f_count_check_list";
    }

    @RequestMapping("/f_count_check/list")
    @ResponseBody
    public EUDateGridResult getItemList(Integer page,Integer rows)
    {
        EUDateGridResult result = finalCountCheckService.getItemList(page,rows);
        return  result;
    }
}
