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





    TechnologyPlan get(String technologyPlanId);

    Result insert(TechnologyPlan technologyPlan);

    Result delete(String[] ids);

    Result update(TechnologyPlan technologyPlan);

    EUDataGridResult search_technologyPlan_by_tevhnologyName(Integer page, Integer rows, String technologyName);

    EUDataGridResult search_technologyPlan_by_tevhnologyPlanId(Integer page, Integer rows, String technologyPlanId);

    List<TechnologyPlan> search();
}
