package com.cskaoyan.controller;

import com.cskaoyan.pojo.PageShowResult;
import com.cskaoyan.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/11 21:59
 * @需求:
 * @思路说明:
 */
@Controller
@RequestMapping("/materialConsume")
public class materialConsumeController {

    @Autowired
    MaterialConsumeService materialConsumeService;


    //跳转到物料列表
    @RequestMapping("/find")
    public String findMaterialConsumeList (){
        return "materialConsume_list";
    }
    /**
     *查询物料收入列表
     * @param page 页数
     * @param rows 每一页的数量
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public PageShowResult showMaterialConsumeList (Integer page, Integer rows){
        PageShowResult list = materialConsumeService.getList(page, rows);
        return list;
    }
}
