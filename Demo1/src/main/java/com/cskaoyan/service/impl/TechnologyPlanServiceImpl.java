package com.cskaoyan.service.impl;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.mapper.TechnologyPlanMapper;
import com.cskaoyan.service.TechnologyPlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;
    @Autowired
    TechnologyMapper technologyMapper;

    @Override
    public EUDataGridResult selectAll(Integer page, Integer rows, TechnologyPlan technologyPlan) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlanList = technologyPlanMapper.selectAll();
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(technologyPlanList);
        PageInfo<TechnologyPlan> technologyPlanPageInfo = new PageInfo<>(technologyPlanList);
        euDataGridResult.setTotal(technologyPlanPageInfo.getTotal());
        return euDataGridResult;
    }

    @Override
    public TechnologyPlan get(String technologyPlanId) {
        TechnologyPlan technologyPlan = technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
        return technologyPlan;
    }

    @Override
    public Result insert(TechnologyPlan technologyPlan) {
        int insert = technologyPlanMapper.insert(technologyPlan);
        if (insert == 1) {
            Result result = new Result();
            result.setMsg("ok");
            result.setData("null");
            result.setStatus(200);
            return result;
        }
        return null;

    }

    @Override
    public Result delete(String[] ids) {
        int i = technologyPlanMapper.deleteByPrimaryKey(ids);
        Result result = new Result();
        if (i >= 1) {
            result.setStatus(200);
            result.setData("null");
            result.setMsg("ok");
            return result;
        }
        return null;
    }

    @Override
    public Result update(TechnologyPlan technologyPlan) {

        int i = technologyPlanMapper.updateByPrimaryKey(technologyPlan);
        if (i == 1) {
            Result result = new Result();
            result.setMsg("ok");
            result.setStatus(200);
            result.setData("null");
            return result;
        } else {
            return null;

        }
    }

    @Override
    public EUDataGridResult search_technologyPlan_by_tevhnologyName(Integer page, Integer rows, String technologyName) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlanList = technologyPlanMapper.selectByTechnologyName(technologyName);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(technologyPlanList);
        PageInfo<TechnologyPlan> technologyPlanPageInfo = new PageInfo<>(technologyPlanList);
        euDataGridResult.setTotal(technologyPlanPageInfo.getTotal());
        return euDataGridResult;
    }

    @Override
    public EUDataGridResult search_technologyPlan_by_tevhnologyPlanId(Integer page, Integer rows, String technologyPlanId) {
        PageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlanList = technologyPlanMapper.selectByTechnologyPlanId(technologyPlanId);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(technologyPlanList);
        PageInfo<TechnologyPlan> technologyPlanPageInfo = new PageInfo<>(technologyPlanList);
        euDataGridResult.setTotal(technologyPlanPageInfo.getTotal());
        return euDataGridResult;
    }

    @Override
    public List<TechnologyPlan> search() {
        return technologyPlanMapper.searchTechnologyPlanId();

    }
}





