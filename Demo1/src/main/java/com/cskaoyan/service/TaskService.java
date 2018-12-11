package com.cskaoyan.service;

import com.cskaoyan.bean.Task;
import com.cskaoyan.utils.JsonFindRet;

public interface TaskService {

    Task findTaskById(String taskId);

    JsonFindRet<Task> findTasks(Task task, Integer page, Integer rows);

    boolean addTask(Task task);

    boolean updateTask(Task task);

    boolean deleteTask(String ids);
}
