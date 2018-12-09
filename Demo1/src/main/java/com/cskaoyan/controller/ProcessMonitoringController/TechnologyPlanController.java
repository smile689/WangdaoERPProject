package com.cskaoyan.controller.ProcessMonitoringController;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
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
public List<Technology>  getData(){
    List <Technology> technologylist=technologyPlanService.search();
    return technologylist;
}
@RequestMapping("/get/{technilogyPlanId}")
@ResponseBody
public TechnologyPlan getItemById(String technilogyPlanId){
    TechnologyPlan technologyPlan=technologyPlanService.get(technilogyPlanId);
    return technologyPlan;

}
@RequestMapping("/insert")
    @ResponseBody
public Result insert(@Valid TechnologyPlan technologyPlan, BindingResult bindingResult){
Result result=null;
if (bindingResult.hasErrors()){
    FieldError fieldError = bindingResult.getFieldError();
    String defaultMessage = fieldError.getDefaultMessage();
    result.setMsg(defaultMessage);
    result.setData("null");
    result.setStatus(0);
    return  result;
}
if (technologyPlanService.get(technologyPlan.getTechnologyPlanId())!=null){

    result = new Result(0, "工序计划编号已经纯在，请重新输入", null);
}
else {
    result=technologyPlanService.insert(technologyPlan);

}
return result;

}






}
