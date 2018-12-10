package com.cskaoyan.controller;

import com.cskaoyan.bean.Task;
import com.cskaoyan.service.TaskService;
import com.cskaoyan.utils.JsonChangeRet;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

/**
 * 生产派工管理--计划进度
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    //找到list.jsp
    @RequestMapping("/find")
    public String findTaskListJsp(){
        return "task_list";
    }

    //分页查找
    @ResponseBody
    @RequestMapping("/list")
    public JsonFindRet<Task> findTasks(Integer page, Integer rows){
        Task task=new Task();
        JsonFindRet<Task> tasks = taskService.findTasks(task, page, rows);
        return tasks;
    }

    //多条件查询
    @ResponseBody
    @RequestMapping("/search_task_by_taskId")
    public JsonFindRet<Task> findTasksByTaskId(String searchValue, Integer page, Integer rows){
        Task task=new Task();
        task.setTaskId(searchValue);
        JsonFindRet<Task> tasks = taskService.findTasks(task, page, rows);
        return tasks;
    }

    @ResponseBody
    @RequestMapping("/search_task_by_taskWorkId")
    public JsonFindRet<Task> findTasksByWorkId(String searchValue,Integer page, Integer rows){
        Task task=new Task();
        task.setWorkId(searchValue);
        JsonFindRet<Task> tasks = taskService.findTasks(task, page, rows);
        return tasks;
    }

    @ResponseBody
    @RequestMapping("/search_task_by_taskManufactureSn")
    public JsonFindRet<Task> findTasksByManufactureSn(String searchValue,Integer page, Integer rows){
        Task task=new Task();
        task.setManufactureSn(searchValue);
        JsonFindRet<Task> tasks = taskService.findTasks(task, page, rows);
        return tasks;
    }

    //判断修改权限
    @ResponseBody
    @RequestMapping(path = {"/add_judge", "/edit_judge", "/delete_judge"})
    public Map taskJudge(){
        return null;
    }

    //转到添加jsp
    @RequestMapping("/add")
    public String findTaskAddJsp(){
        return "task_add";
    }

    //处理添加的信息，参数校验
    @ResponseBody
    @RequestMapping("/insert")
    public JsonChangeRet addTask(@Valid Task task, BindingResult bindingResult){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        Task taskById = taskService.findTaskById(task.getTaskId());
        if(taskById!=null&&taskById.getTaskId()!=null){
            jsonChangeRet.setMsg("ID重复，更换ID");
            return jsonChangeRet;
        }
        if(taskService.addTask(task)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }

    //跳转到编辑jsp
    @RequestMapping("/edit")
    public String findTaskEditJsp(){
        return "/task_edit";
    }

    //处理信息编辑，参数校验
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateTask(@Valid Task task, BindingResult bindingResult){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if (errorMsg!=null&&!(errorMsg.trim().isEmpty())) {
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        if(taskService.updateTask(task)){
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
    public JsonChangeRet deleteTask(String ids){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        boolean isDeleteAll = taskService.deleteTask(ids);
        if(isDeleteAll){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败，重新添加");
        }
        return jsonChangeRet;
    }
}
