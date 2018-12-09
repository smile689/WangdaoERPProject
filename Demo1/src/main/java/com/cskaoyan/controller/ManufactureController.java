package com.cskaoyan.controller;

import com.cskaoyan.bean.Corder;
import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.bean.Technology;
import com.cskaoyan.service.ManufactureService;
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
import java.util.List;
import java.util.Map;

/**
 * 生产计划管理--计划进度
 */
@Controller
@RequestMapping("/manufacture")
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    @RequestMapping("/find")
    public String findManufactureListJsp(){
        return "manufacture_list";
    }

    @ResponseBody
    @RequestMapping("/get/{manufactureSn}")
    public Manufacture getManufactureBySn(@PathVariable String manufactureSn){
        return manufactureService.findManufactureById(manufactureSn);
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List<Manufacture> getAllManufactures(){
        return manufactureService.findAll();
    }

    @ResponseBody
    @RequestMapping("/list")
    public JsonFindRet<Manufacture> findManufactures(Integer page, Integer rows){
        Manufacture manufacture=new Manufacture();
        JsonFindRet<Manufacture> manufactures = manufactureService.findManufactures(manufacture, page, rows);
        return manufactures;
    }

    //多条件查询
    @ResponseBody
    @RequestMapping("/search_manufacture_by_manufactureSn")
    public JsonFindRet<Manufacture> searchManufactureByManufactureSn(String searchValue, Integer page, Integer rows){
        Manufacture manufacture=new Manufacture();
        manufacture.setManufactureSn(searchValue);
        JsonFindRet<Manufacture> manufactures = manufactureService.findManufactures(manufacture, page, rows);
        return manufactures;
    }

    @ResponseBody
    @RequestMapping("/search_manufacture_by_manufactureOrderId")
    public JsonFindRet<Manufacture> searchManufactureByOrderId(String searchValue, Integer page, Integer rows){
        Corder corder=new Corder();
        corder.setOrderId(searchValue);
        Manufacture manufacture=new Manufacture();
        manufacture.setcOrder(corder);
        JsonFindRet<Manufacture> manufactures = manufactureService.findManufactures(manufacture, page, rows);
        return manufactures;
    }

    @ResponseBody
    @RequestMapping("/search_manufacture_by_manufactureTechnologyName")
    public JsonFindRet<Manufacture> searchManufactureByTechnologyName(String searchValue, Integer page, Integer rows){
        Technology technology=new Technology();
        technology.setTechnologyName(searchValue);
        Manufacture manufacture=new Manufacture();
        manufacture.setTechnology(technology);
        JsonFindRet<Manufacture> manufactures = manufactureService.findManufactures(manufacture, page, rows);
        return manufactures;
    }

    //判断增删改权限
    @ResponseBody
    @RequestMapping(path = {"/add_judge", "/edit_judge", "/delete_judge"})
    public Map manufactureJudge(){
        return null;
    }

    //转到添加jsp
    @RequestMapping("/add")
    public String findManufactureAddJsp(){
        return "manufacture_add";
    }

    //处理添加
    @ResponseBody
    @RequestMapping("/insert")
    public JsonChangeRet addWork(@Valid Manufacture manufacture, BindingResult bindingResult, Corder corder, Technology technology){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        manufacture.setcOrder(corder);
        manufacture.setTechnology(technology);
        if(manufactureService.addManufacture(manufacture)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //跳转到编辑jsp
    @RequestMapping("/edit")
    public String findManufactureEditJsp(){
        return "manufacture_edit";
    }

    //处理编辑
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateManufacture(@Valid Manufacture manufacture, BindingResult bindingResult, Corder corder, Technology technology){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        manufacture.setcOrder(corder);
        manufacture.setTechnology(technology);
        if(manufactureService.updateManufacture(manufacture)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //处理删除
    @ResponseBody
    @RequestMapping("/delete_batch")
    public JsonChangeRet deleteManufacture(String ids){
        boolean isDeleteAll=manufactureService.deleteManufacture(ids);
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
