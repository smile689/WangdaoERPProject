package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
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
        PageHelper.startPage(page,rows);
        List<TechnologyPlan> technologyPlanList=technologyPlanMapper.selectAll();
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(technologyPlanList);
        PageInfo<TechnologyPlan> technologyPlanPageInfo = new PageInfo<>(technologyPlanList);
        euDataGridResult.setTotal(technologyPlanPageInfo.getTotal());
        return euDataGridResult;
    }



    @Override
    public List<Technology> search() {
        List<Technology> technologyList = technologyMapper.selectByTechnologyName();
      return technologyList;

    }

    @Override
    public TechnologyPlan get(String technilogyPlanId) {
        TechnologyPlan technologyPlan = technologyPlanMapper.selectByPrimaryKey(technilogyPlanId);
        return technologyPlan;
    }

    @Override
    public Result insert(TechnologyPlan technologyPlan) {
        int insert = technologyPlanMapper.insert(technologyPlan);
        if (insert==1){
            Result result = new Result();
              result.setMsg("ok");
                result.setData("null");
                result.setStatus(200);
                return result;
            }
            return null;

        }
    }

