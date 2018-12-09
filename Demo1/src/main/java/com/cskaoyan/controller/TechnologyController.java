package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.service.TechnologyService;
import com.cskaoyan.utils.JsonChangeRet;
import com.cskaoyan.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technology")
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    //根据id查找
    @ResponseBody
    @RequestMapping("/get/{technologyId}")
    public Technology getTechnologyById(@PathVariable String technologyId){
        return technologyService.findTechnologyById(technologyId);
    }

    //判断修改权限
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map technologyJudge(){
        return null;
    }

    //外键getData获得所有信息
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Technology> findAllTechnology(){
        return technologyService.findAll();
    }

    //修改处理
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateTechnology(Technology technology){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        if(technologyService.updateTechnology(technology)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }


}
