package com.cskaoyan.controller;

import com.cskaoyan.bean.Process;
import com.cskaoyan.service.ProcessService;
import com.cskaoyan.utils.JsonChangeRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    //找到所有process
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Process> findAll(){
        return processService.findAll();
    }

    //根据id找到对应项
    @ResponseBody
    @RequestMapping("/get/{processId}")
    public Process getProcessById(@PathVariable String processId){
        return processService.findProcessById(processId);
    }

    //修改权限判断
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map processJudge(){
        return null;
    }

    //修改
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateProcess(Process process){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        if(processService.updateProcess(process)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;

    }
}
