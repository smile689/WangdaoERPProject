package com.cskaoyan.service;

import com.cskaoyan.bean.Process;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;

import java.util.ArrayList;
import java.util.List;

public interface ProcessService {



    EUDataGridResult selectAll(Integer page, Integer rows, Process process);

    Process get(String processId);


    Result delete_batch(String[] ids);

    Result updateAll(Process process);

    EUDataGridResult search_process_by_processId(Integer page, Integer rows, String processId);

    EUDataGridResult search_process_by_technologyPlanId(Integer page, Integer rows, String technologyPlanId);

    Result insert(Process process);

    List<Process> search();
}
