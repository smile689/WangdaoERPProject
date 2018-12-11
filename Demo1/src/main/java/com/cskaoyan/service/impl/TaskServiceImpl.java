package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Task;
import com.cskaoyan.mapper.TaskMapper;
import com.cskaoyan.service.TaskService;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;


    @Transactional(readOnly = true)
    @Override
    public Task findTaskById(String taskId) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public JsonFindRet<Task> findTasks(Task task, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Task> taskList = taskMapper.selectByPage(task);
        PageInfo<Task> taskPageInfo=new PageInfo<>(taskList);
        JsonFindRet<Task> jsonFindRet=new JsonFindRet<>();
        jsonFindRet.setTotal(taskPageInfo.getTotal());
        jsonFindRet.setRows(taskList);
        return jsonFindRet;
    }

    @Transactional
    @Override
    public boolean addTask(Task task) {
        return taskMapper.insert(task)==1;
    }

    @Transactional
    @Override
    public boolean updateTask(Task task) {
        return taskMapper.updateByPrimaryKey(task)==1;
    }

    @Transactional
    @Override
    public boolean deleteTask(String ids) {
        String[] split = ids.split(",");
        for (String id: split) {
            if(taskMapper.deleteByPrimaryKey(id)!=1){
                return false;
            }
        }
        return true;
    }
}
