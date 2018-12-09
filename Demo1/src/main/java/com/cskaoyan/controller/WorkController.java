package com.cskaoyan.controller;

import com.cskaoyan.bean.Device;
import com.cskaoyan.bean.Process;
import com.cskaoyan.bean.Product;
import com.cskaoyan.bean.Work;
import com.cskaoyan.service.WorkService;
import com.cskaoyan.utils.JsonChangeRet;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/work")
public class WorkController {

    @Autowired
    WorkService workService;


    @RequestMapping("/find")
    public String findWorkListJsp(){
        return "work_list";
    }

    @ResponseBody
    @RequestMapping("/get/{workId}")
    public Work getWorkById(@PathVariable String workId){
        return workService.findWorkById(workId);
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List<Work> getAllWorks(){
        return workService.findAll();
    }

    @ResponseBody
    @RequestMapping("/list")
    public JsonFindRet<Work> findCustoms(Integer page, Integer rows){
        Work work=new Work();
        JsonFindRet<Work> works =workService.findWorks(work, page, rows);
        return works;
    }

    //多条件查询
    @ResponseBody
    @RequestMapping("/search_work_by_workId")
    public JsonFindRet<Work> searchWorkByWorkId(String searchValue, Integer page, Integer rows){
        Work work=new Work();
        work.setWorkId(searchValue);
        JsonFindRet<Work> works =workService.findWorks(work, page, rows);
        return works;
    }

    @ResponseBody
    @RequestMapping("/search_work_by_workDevice")
    public JsonFindRet<Work> searchWorkByDevice(String searchValue, Integer page, Integer rows){
        Device device=new Device();
        device.setDeviceName(searchValue);
        Work work=new Work();
        work.setDevice(device);
        JsonFindRet<Work> works =workService.findWorks(work, page, rows);
        return works;
    }

    @ResponseBody
    @RequestMapping("/search_work_by_workProcess")
    public JsonFindRet<Work> searchWorkByProcess(String searchValue, Integer page, Integer rows){
        Process process=new Process();
        process.setProcessId(searchValue);
        Work work=new Work();
        work.setProcess(process);
        JsonFindRet<Work> works =workService.findWorks(work, page, rows);
        return works;
    }

    @ResponseBody
    @RequestMapping("/search_work_by_workProduct")
    public JsonFindRet<Work> searchWorkByProduct(String searchValue, Integer page, Integer rows){
        Product product=new Product();
        product.setProductName(searchValue);
        Work work=new Work();
        work.setProduct(product);
        JsonFindRet<Work> works =workService.findWorks(work, page, rows);
        return works;
    }

    //增删改权限检查
    @ResponseBody
    @RequestMapping(path = {"/add_judge", "/edit_judge", "/delete_judge"})
    public Map workJudge(){
        return new HashMap();
    }

    //跳转到增加页面
    @RequestMapping("/add")
    public String findWorkAddJsp(){
        return "work_add";
    }


    //处理增加
    @ResponseBody
    @RequestMapping("/insert")
    public JsonChangeRet addWork(@Valid Work work, BindingResult bindingResult, Product product, Process process,Device device){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        work.setDevice(device);
        work.setProcess(process);
        work.setProduct(product);
        if(workService.addWork(work)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //跳转到编辑jsp
    @RequestMapping("/edit")
    public String findWorkEditJsp(){
        return "/work_edit";
    }

    //处理编辑
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateWork(@Valid Work work, BindingResult bindingResult, Product product, Process process,Device device){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        work.setDevice(device);
        work.setProcess(process);
        work.setProduct(product);
        if(workService.updateWork(work)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //批量删除
    @ResponseBody
    @RequestMapping("/delete_batch")
    public JsonChangeRet deleteWork(String ids){
        boolean isDeleteAll=workService.deleteWork(ids);
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        if(isDeleteAll){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }


}
