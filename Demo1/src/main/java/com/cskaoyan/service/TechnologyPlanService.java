package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyPlan;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnologyPlanService {
    EUDataGridResult selectAll(Integer page, Integer rows, TechnologyPlan technologyPlan);




    List<Technology> search();

    TechnologyPlan get(String technilogyPlanId);

    Result insert(TechnologyPlan technologyPlan);
}
