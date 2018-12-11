package com.cskaoyan.controller;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/technology")
public class TechnologyController {

@Autowired
private TechnologyService technologyService;

/**
 * 详单页面
 *
 * */
@RequestMapping("/find")
    public String find(){
return "technology_list";
}

/**
 * list回显
 *
 * */
@RequestMapping("/list")
@ResponseBody
public EUDataGridResult getItemList(Integer page,Integer rows,Technology technology){
  EUDataGridResult euDataGridResult=technologyService.getList(page,rows,technology);
return euDataGridResult;
}
/**
 * 添加页面
 *
 * */
@RequestMapping("/add")
    public  String add(){
    return "technology_add";
}
/**
 *新增一个工艺
 * /**
 *  * 通过id获取工艺，判断是否重复
 *
 *  通过get请求回显。
 *  *
 *  * */
@RequestMapping(value = "/get/{technologyId}")
@ResponseBody
public Technology getItemById(@PathVariable("technologyId") String technologyId){
    Technology technology= technologyService.get(technologyId);
    return technology;
}
/**
 * 弹框
 * */
@RequestMapping("/add_judge")
@ResponseBody
public Result add_judge(){
    return null;
}
@RequestMapping(value = "/insert",method= RequestMethod.POST)
    @ResponseBody
    public Result insert(@Valid Technology technology, BindingResult bindingResult, Model model){
    Result result ;
    //验证
    if (bindingResult.hasErrors()){
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        model.addAttribute("error",defaultMessage);
    }
    //校验
    if (technologyService.get(technology.getTechnologyId())!=null){
        result = new Result(0, "工艺编号已经纯在，请重新输入", null);
    }
    else {
       result= technologyService.insert(technology);
    }
    return result;

}

@RequestMapping("/get_data")
@ResponseBody
public List<Technology> get_data(){

    List<Technology> technologyList=technologyService.search();
    return technologyList;
}


/**
 *
 * 删除工艺
 * */
@RequestMapping("/delete_judge")
@ResponseBody
public Result delete_judge(){
    return null;
}
@RequestMapping("/delete_batch")
@ResponseBody
public Result delete_batch(String[] ids ){
    Result result=technologyService.deleteById(ids);
return result;
}
/**
   * 编辑
 *
 * */
    @RequestMapping("/edit")
    public String edit(){

        return "technology_edit";
    }

/**
 * 编辑一个工艺
 *
 * */
@RequestMapping("/edit_judge")
    @ResponseBody
    public Result edit_judge(){
    return null;
}
@RequestMapping("/update_all")
    @ResponseBody
    public Result updateAll(@Valid Technology technology,BindingResult bindingResult,Model model){


    if (bindingResult.hasErrors()) {
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        model.addAttribute("error",defaultMessage);
    }
    return technologyService.updateAll(technology);

}
/**
*
 * 工艺编号
* */
@RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public EUDataGridResult search_technology_by_technologyId(Integer page,Integer rows,String searchValue){
    EUDataGridResult euDataGridResult=technologyService.search_technology_by_technologyId(page,rows,searchValue);
    return euDataGridResult;
}



/**
 * 工艺名称
 * */
@RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public EUDataGridResult search_technology_by_technologyName(Integer page,Integer rows,String searchValue){
   EUDataGridResult euDataGridResult= technologyService.search_technology_by_technologyName(page,rows,searchValue);

    return euDataGridResult;
}




















}
