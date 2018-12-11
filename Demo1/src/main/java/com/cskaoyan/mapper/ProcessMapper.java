package com.cskaoyan.mapper;

import com.cskaoyan.bean.Process;


import java.util.List;

public interface ProcessMapper {


    int insertSelective(Process record);

    Process selectByPrimaryKey(String processId);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process process);


    List<Process> selectAll();

    int deleteByPrimaryKey(String[] ids);


    List<Process> searchProcessByProcessId(String processId);

    List<Process> searchProcessByTechnologyPlanId(String technologyPlanId);

    List<Process> selectProcessId();

    int insert(Process process);
}