package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnologyRequirementService {
    EUDataGridResult getList(Integer page, Integer rows, TechnologyRequirement technologyRequirement);

    TechnologyRequirement get(String technologyId);

    Result insert(TechnologyRequirement technologyRequirement);

    List<Technology> search();

    Result updateAll(TechnologyRequirement technologyRequirement);

    Result delete(String[] ids);

    EUDataGridResult search_technologyRequirement_by_technologyRequirementId(Integer page, Integer rows, String technologyRequirementId);

    EUDataGridResult search_technologyRequirement_by_technologyName(Integer page, Integer rows, String technologyName);
}
