package com.cskaoyan.controller;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.service.CustomService;
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

@Controller
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    CustomService customService;

    //点击对应标签后跳转到list的jsp
    @RequestMapping("/find")
    public String findCustomListJsp(){
        return "custom_list";
    }

    //根据id找
    @ResponseBody
    @RequestMapping("/get/{customId}")
    public Custom getCustomById(@PathVariable String customId){
        return customService.findCustomById(customId);
    }

    @ResponseBody
    @RequestMapping("/list")
    public JsonFindRet<Custom> findCustoms(Integer page, Integer rows){
        Custom custom=new Custom();
        JsonFindRet<Custom> customs = customService.findCustoms(custom, page, rows);
        return customs;
    }

    @ResponseBody
    @RequestMapping("/search_custom_by_customId")
    public JsonFindRet<Custom> searchCustomByCustomId(String searchValue,Integer page, Integer rows){
        Custom custom=new Custom();
        custom.setCustomId(searchValue);
        JsonFindRet<Custom> customList=customService.findCustoms(custom, page, rows);
        return customList;
    }

    @ResponseBody
    @RequestMapping("/search_custom_by_customName")
    public JsonFindRet<Custom> searchCustomByCustomName(String searchValue, Integer page, Integer rows){
        Custom custom=new Custom();
        custom.setCustomName(searchValue);
        JsonFindRet<Custom> customList=customService.findCustoms(custom, page, rows);
        return customList;
    }

//增

    //检查是否有权限增删改查
    @ResponseBody
    @RequestMapping(path = {"/add_judge","/edit_judge","/delete_judge"} )
    public Map customJudge(){
        return null;
    }

    //打开添加信息窗口
    @RequestMapping("/add")
    public String findCustomAddJsp(){
        return "custom_add";
    }

    //处理添加的信息，参数校验
    @ResponseBody
    @RequestMapping("/insert")
    public JsonChangeRet addCustom(@Valid Custom custom, BindingResult bindingResult){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        Custom customById = customService.findCustomById(custom.getCustomId());
        if(customById!=null&&customById.getCustomId()!=null){
            jsonChangeRet.setMsg("ID重复，更换ID");
            return jsonChangeRet;
        }
        if(customService.addCustom(custom)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

//改
    //打开编辑信息窗口
    @RequestMapping("/edit")
    public String findCustomEditJsp(){
        return "custom_edit";
    }

    //处理信息编辑，参数校验
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateCustom(@Valid Custom custom, BindingResult bindingResult){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        if(customService.updateCustom(custom)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //修改note，传来id和note
    @ResponseBody
    @RequestMapping("/update_note")
    public JsonChangeRet updateNode(Custom custom){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        if(customService.updateNote(custom)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //删除
    @ResponseBody
    @RequestMapping("/delete_batch")
    public JsonChangeRet deleteCustom(String ids){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        boolean isDeleteAll = customService.deleteCustom(ids);
        if(isDeleteAll){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    @ResponseBody
    @RequestMapping("/get_data")
    public List<Custom> getAllCustoms(){
        return customService.findAll();
    }

}
