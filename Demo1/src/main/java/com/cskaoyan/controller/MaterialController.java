package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/6 16:54
 * @需求:
 * @思路说明:
 */
@Controller
@RequestMapping("/material")
public class MaterialController {


    @RequestMapping(value = "/{formName}")
    public String toLogin(@PathVariable String formName){
        return "/WEB-INF/jsp/"+formName+".jsp";
    }
    @RequestMapping("/find")
    public String findMaterialList (){
        return "/WEB-INF/jsp/material_list.jsp";
    }
    @RequestMapping("/list")
    public Map showMaterialList (){
        HashMap<String,Object> list = new HashMap<>();
        return list;
    }

}
