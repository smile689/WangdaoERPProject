package com.cskaoyan.controller;

import com.cskaoyan.bean.Process;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.service.ProcessService;
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


@Controller
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    private ProcessService processService;

/**list
*订单回显
* */
@RequestMapping("/find")
    public String find(){

    return "process_list";
}

@RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult  getItemList(Integer page, Integer rows,Process process){

    EUDataGridResult euDataGridResult=processService.selectAll(page,rows,process);
    return euDataGridResult;
}


/**
 * 新增
 *
 */
  @RequestMapping("/add")
  public String add(){
      return "process_add";
  }
  @RequestMapping("/add_judge")
  @ResponseBody
  public Result add_judge(){
      return  null;
  }
  /**
     * 根据id找到对应的
     *
     * */
  @RequestMapping("/get/{processId}")
  @ResponseBody
  public Process getItemById(@PathVariable("processId") String processId){
     Process process= processService.get(processId);
     return process;
  }

  @RequestMapping("/get_data")
  @ResponseBody
  public List<Process> getData(){
      List <Process>list=processService.search();
      return list;

  }
  @RequestMapping(value = "/insert",method = RequestMethod.POST)
  @ResponseBody
  public Result insert(@Valid Process process, BindingResult bindingResult){
      Result result=new Result();
      if (bindingResult.hasErrors()) {

          List<FieldError> fieldErrors = bindingResult.getFieldErrors();
          for (FieldError fieldError : fieldErrors
          ) {
              String defaultMessage = fieldError.getDefaultMessage();
              System.out.println(defaultMessage);
              result.setMsg(defaultMessage);
              result.setData(null);
              result.setStatus(null);
              return result;
          }
      }
      if (processService.get(process.getProcessId())!=null){
          result = new Result(0, "工序编号已经纯在，请重新输入", null);
      }
      else {
            result=processService.insert(process);

      }
      return result;
  }


/**
 * 删除
 * */

@RequestMapping("/delete_judge")
    @ResponseBody
    public Result delete_judge(){

    return null;
}
@RequestMapping("/delete_batch")
    @ResponseBody
    public Result delete_batch(String[] ids){
    Result result=processService.delete_batch(ids);
    return  result;
}
/**
 * 编辑
 * */
@RequestMapping("/edit")
    public String edit(){
    return "process_edit";
}
   @RequestMapping("/edit_judge")
    @ResponseBody
    public Result edit_judge(){
    return null;
}

@RequestMapping("/update_all")
    @ResponseBody
    public  Result updateAll(@Valid Process process,BindingResult bindingResult){
    Result result=null;
    if (bindingResult.hasErrors()){
        FieldError fieldError = bindingResult.getFieldError();
        String defaultMessage = fieldError.getDefaultMessage();
        result.setMsg(defaultMessage);
        result.setStatus(0);
        result.setData("null");
        return  result;
    }
    return processService.updateAll(process);
}
/**
 * 通过工序编号查找
 * */

@RequestMapping("/search_process_by_processId")
    @ResponseBody
    public EUDataGridResult search_process_by_processId(Integer page,Integer rows,String searchValue){
   EUDataGridResult euDataGridResult= processService.search_process_by_processId(page,rows,searchValue);
   return euDataGridResult;
}
/**
 * 通过工艺计划编号
 * */
@RequestMapping("/search_process_by_technologyPlanId")
    @ResponseBody
    public  EUDataGridResult search_process_by_technologyPlanId(Integer page,Integer rows,String searchValue){
    EUDataGridResult euDataGridResult=   processService.search_process_by_technologyPlanId(page,rows,searchValue);
return  euDataGridResult;

}















}
