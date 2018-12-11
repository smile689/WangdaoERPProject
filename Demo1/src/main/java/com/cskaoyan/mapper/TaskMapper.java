package com.cskaoyan.mapper;

import com.cskaoyan.bean.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKey(Task record);

    List<Task> selectByPage(@Param("task") Task task);
}