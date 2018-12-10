package com.cskaoyan.controller;

import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
private     TechnologyRequirementService technologyRequirementService;
/**
 * 详单
 *
 * list回显
 * */
@RequestMapping("/find")
public String find(){

    return "technologyRequirement_list";

}
@RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows, TechnologyRequirement technologyRequirement){
    EUDataGridResult euDataGridResult=technologyRequirementService.getList(page,rows,technologyRequirement);
    return euDataGridResult;
}
    /**
     * 添加页面
     *
     * */
    @RequestMapping("/add")
    public  String add(){
        return "technologyRequirement_add";
    }
    /**
     *新增一个要求
     * /**
     *  * 通过id获取要求，判断是否重复
     *  *
     *  * */
    @RequestMapping(value = "/get/{technologyRequirementId}")
    @ResponseBody
    public TechnologyRequirement getItemById(String technologyRequirementId){
        TechnologyRequirement technologyRequirement= technologyRequirementService.get(technologyRequirementId);
        return technologyRequirement;
    }
    /**
     * 弹框
     * */
    @RequestMapping("/add_judge")
    @ResponseBody
    public Result add_judge(){
        return null;
    }
/**
 * 新增
 * */
@RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public Result insert(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult, Model model) {
    Result result;
    //验证
    if (bindingResult.hasErrors()) {
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        model.addAttribute("error", defaultMessage);
    }
    //校验
    if (technologyRequirementService.get(technologyRequirement.getTechnologyRequirementId()) != null) {
        result = new Result(0, "工艺要求编号已经存在，请重新输入", null);
        return result;
    } else {
        result = technologyRequirementService.insert(technologyRequirement);

    }
    return result;

}
/**
 * 获取下工艺名称下拉框
 * */

/**
 * 编辑
 *
 * */
@RequestMapping("/edit_judge")
    @ResponseBody
    public Result edit_judge(){
    return null;
}
@RequestMapping("/edit")
public String edit(){
    return "technologyRequirement_edit";
}
@RequestMapping("/update_all")
    @ResponseBody
    public Result update(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult,Model model){
if (bindingResult.hasErrors()){
    FieldError fieldError = bindingResult.getFieldError();
    String defaultMessage = fieldError.getDefaultMessage();
    model.addAttribute("error",defaultMessage);
}
return technologyRequirementService.updateAll(technologyRequirement);
}

/**
 * 删除
 * */
@RequestMapping("/delete_judge")
@ResponseBody
    public  Result delete_judge(){
    return null;
}
@RequestMapping("/delete_batch")
    @ResponseBody
    public Result delete(String[] ids){

    Result result=technologyRequirementService.delete(ids);
    return  result;

}
/**
 * 通过编号查找
 * */

@RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public EUDataGridResult search_technologyRequirement_by_technologyRequirementId(Integer page,Integer rows,String searchValue){

   EUDataGridResult euDataGridResult= technologyRequirementService.search_technologyRequirement_by_technologyRequirementId(page,rows,searchValue);
   return  euDataGridResult;

}
/**
*
* 通过名称查找
* */

@RequestMapping("/search_technologyRequirement_by_technologyName")
@ResponseBody
    public EUDataGridResult search_technologyRequirement_by_technologyName(Integer page,Integer rows,String searchValue){

    EUDataGridResult euDataGridResult=technologyRequirementService.search_technologyRequirement_by_technologyName(page,rows,searchValue);
    return euDataGridResult;

}

/**
 * 修改工艺要求
 * */
@RequestMapping("/update_requirement")
    @ResponseBody
    public Result update_requirement(@Valid TechnologyRequirement technologyRequirement,BindingResult bindingResult){
    Result result=null;
    if (bindingResult.hasErrors()){
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        result.setMsg(defaultMessage);
        result.setStatus(0);
        result.setData("null");
        return  result;
    }
 return technologyRequirementService.update_requirement(technologyRequirement);


}





}
