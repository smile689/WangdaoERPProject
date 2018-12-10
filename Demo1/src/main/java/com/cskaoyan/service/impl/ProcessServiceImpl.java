package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Process;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.mapper.ProcessMapper;
import com.cskaoyan.mapper.TechnologyPlanMapper;
import com.cskaoyan.service.ProcessService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;

    @Override
    public EUDataGridResult selectAll(Integer page, Integer rows, Process process) {
        PageHelper.startPage(page,rows);
      List<Process> processList= processMapper.selectAll();
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(processList);
        PageInfo<Process> processPageInfo = new PageInfo<>(processList);
        euDataGridResult.setTotal(processPageInfo.getTotal());
        return euDataGridResult;
    }

    @Override
    public Process get(String processId) {
        Process process = processMapper.selectByPrimaryKey(processId);
        return process;
    }

    @Override
    public List<Process> search() {
return technologyPlanMapper.selectTechnologyPlanId();
    }

    @Override
    public Result delete_batch(String[] ids) {
        int i= processMapper.deleteByPrimaryKey(ids);
        Result result = new Result();
        if (i==1){
            result.setMsg("ok");
            result.setStatus(200);
            result.setData("null");
            return result;
        }
        return null;
    }

    @Override
    public Result updateAll(Process process) {
        int i = processMapper.updateByPrimaryKey(process);
        if (i==1){
            Result result = new Result();
            result.setMsg("ok");
            result.setStatus(200);
            result.setData("null");
            return result;
        }
        else {
            return  null;

        }
    }

    @Override
    public EUDataGridResult search_process_by_processId(Integer page, Integer rows, String processId) {
        PageHelper.startPage(page,rows);
      List<Process >processList=  processMapper.searchProcessByProcessId(processId);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(processList);
        PageInfo<Process> processPageInfo = new PageInfo<>(processList);
        euDataGridResult.setTotal(processPageInfo.getTotal());
        return euDataGridResult;

    }

    @Override
    public EUDataGridResult search_process_by_technologyPlanId(Integer page, Integer rows, String technologyPlanId) {
PageHelper.startPage(page,rows);
List<Process> processList=processMapper.searchProcessByTechnologyPlanId(technologyPlanId);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(processList);
        PageInfo<Process> processPageInfo = new PageInfo<>(processList);
        euDataGridResult.setTotal(processPageInfo.getTotal());
        return  euDataGridResult;


    }

    @Override
    public Result insert(Process process) {
        return null;
    }

}
