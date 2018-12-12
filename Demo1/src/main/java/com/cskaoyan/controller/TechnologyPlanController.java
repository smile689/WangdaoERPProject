package com.cskaoyan.controller;

import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/technologyPlan")
@Controller
public class TechnologyPlanController {
@Autowired
    TechnologyPlanService technologyPlanService;
/**
 *list
 *
 * 详情页面
 * */
@RequestMapping("/find")
    public String find(){
    return "technologyPlan_list";
}
@RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows, TechnologyPlan technologyPlan){
    EUDataGridResult euDataGridResult=technologyPlanService.selectAll(page,rows,technologyPlan);
    return  euDataGridResult;
}
/**
 *新增
 * */
@RequestMapping("/add")
    public String add(){

    return "technologyPlan_add";
}
@RequestMapping("/add_judge")
    @ResponseBody
    public Result add_judge(){
    return null;
}

@RequestMapping("/get_data")
@ResponseBody
public List<TechnologyPlan> get_data(){
    List<TechnologyPlan> technologyPlanList=technologyPlanService.search();
    return technologyPlanList;

}


@RequestMapping("/get/{technologyPlanId}")
@ResponseBody
public TechnologyPlan getItemById(@PathVariable("technologyPlanId") String technologyPlanId){
    TechnologyPlan technologyPlan=technologyPlanService.get(technologyPlanId);
    return technologyPlan;

}
@RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
public Result insert(@Valid TechnologyPlan technologyPlan, BindingResult bindingResult){
Result result=new Result();
if (bindingResult.hasErrors()){

    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
    for (FieldError fieldError:fieldErrors
         ) {
        String defaultMessage = fieldError.getDefaultMessage();
        System.out.println(defaultMessage);
    result.setMsg(defaultMessage);
    result.setData(null);
    result.setStatus(null);
    return  result;
}

}
if (technologyPlanService.get(technologyPlan.getTechnologyPlanId())!=null){

    result = new Result(0, "工序计划编号已经纯在，请重新输入", null);
}
else {
    result=technologyPlanService.insert(technologyPlan);

}
return result;

}

/**
 * 删除
 *
 * */
@RequestMapping("/delete_judge")
    @ResponseBody
    public Result delete_judge(){
    return null;
}
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result delete_batch(String [] ids){

    Result result=technologyPlanService.delete(ids);
    return result;

 }
/**
 * 编辑
 *
 * */
@RequestMapping("/edit")
    public String edit(){
    return "technologyPlan_edit";

}
@RequestMapping("edit_judge")
@ResponseBody
    public Result edit_judge(){
    return null;
}

@RequestMapping("/update_all")
    @ResponseBody
    public Result update(@Valid TechnologyPlan technologyPlan,BindingResult bindingResult){
    Result result=null;
    if (bindingResult.hasErrors()){
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        result.setMsg(defaultMessage);
        result.setStatus(0);
        result.setData("null");
        return  result;
    }
    return technologyPlanService.update(technologyPlan);
}
///**
// * 工艺名称
// * */
//
//@RequestMapping("/search_technologyPlan_by_technologyName")
//    @ResponseBody
//    public EUDataGridResult search_technologyPlan_by_technologyName(Integer page,Integer rows,String searchValue){
//    EUDataGridResult euDataGridResult=technologyPlanService.search_technologyPlan_by_tevhnologyName(page,rows,searchValue);
//    return euDataGridResult;
//
//}
//
//
//
//
//
///**
// * 工艺计划编号
// * */
//@RequestMapping("/search_technologyPlan_by_technologyPlanId")
//
//@ResponseBody
//public EUDataGridResult search_technologyPlan_by_technologyPlanId(Integer page,Integer rows,String searchValue){
//    EUDataGridResult euDataGridResult=technologyPlanService.search_technologyPlan_by_tevhnologyPlanId(page,rows,searchValue);
//    return euDataGridResult;
//
//}
//
@RequestMapping("/{name}")
@ResponseBody
    public EUDataGridResult test(@PathVariable String name,Integer page,Integer rows,String searchValue) {

  EUDataGridResult euDataGridResult=null;
    if (name.endsWith("Id")){

        euDataGridResult=technologyPlanService.search_technologyPlan_by_tevhnologyPlanId(page,rows,searchValue);
    }
    if (name.endsWith("Name")){
        euDataGridResult=technologyPlanService.search_technologyPlan_by_tevhnologyName(page,rows,searchValue);

    }
    return  euDataGridResult;
    }


    }








