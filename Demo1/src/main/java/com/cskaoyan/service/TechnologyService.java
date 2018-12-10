package com.cskaoyan.service;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TechnologyService {

    Technology get(String technologyId);

    EUDataGridResult getList(Integer page, Integer rows, Technology technology);

    Result insert(Technology technology);

    Result deleteById(String[] ids);

    Result updateAll(Technology technology);

    EUDataGridResult search_technology_by_technologyId(Integer page, Integer rows, String tenologyId);

    EUDataGridResult search_technology_by_technologyName(Integer page, Integer rows, String technologyName);

    List<Technology> search();
}
