package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.mapper.TechnologyRequirementMapper;
import com.cskaoyan.service.TechnologyRequirementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;
    @Autowired
    TechnologyMapper technologyMapper;
    @Override
    public EUDataGridResult getList(Integer page, Integer rows, TechnologyRequirement technologyRequirement) {
        PageHelper.startPage(page,rows);
        List<TechnologyRequirement> technologyRequirementList= technologyRequirementMapper.selectAll(page,rows,technologyRequirement);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(technologyRequirementList);
        PageInfo<TechnologyRequirement>technologyRequirementPageInfo= new PageInfo<>(technologyRequirementList);
        euDataGridResult.setTotal(technologyRequirementPageInfo.getTotal());
        return euDataGridResult;
    }
    @Override
    public TechnologyRequirement get(String technologyRequirementId) {
        TechnologyRequirement technologyRequirement = technologyRequirementMapper.selectByPrimaryKey(technologyRequirementId);
        return technologyRequirement;
    }

    @Override
    public Result insert(TechnologyRequirement technologyRequirement) {
        int insert = technologyRequirementMapper.insert(technologyRequirement);
        Result result = new Result();
        if (insert==1){
            result.setMsg("ok");
            result.setData("null");
              result.setStatus(200);
              return result;
        }
        return null;
    }



    @Override
    public Result updateAll(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
        Result result = new Result();
        if (i==1){
            result.setMsg("ok");
            result.setData("null");
            result.setStatus(200);
            return result;
        }else {
            return null;
        }
    }

    @Override
    public Result delete(String[] ids) {
       int i= technologyRequirementMapper.deleteByPrimaryKey(ids);
       if (i>=1){
           Result result = new Result();
           result.setStatus(200);
           result.setData("null");
           result.setMsg("ok");
           return  result;
       }
       return  null;
    }

    @Override
    public EUDataGridResult search_technologyRequirement_by_technologyRequirementId(Integer page, Integer rows, String technologyRequirementId) {

        PageHelper.startPage(page, rows);
        List<Technology> list = technologyRequirementMapper.selectTechnologyRequirementByTechnologyRequirementId(technologyRequirementId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult search_technologyRequirement_by_technologyName(Integer page, Integer rows, String technologyName) {
        PageHelper.startPage(page, rows);
        List<Technology> list1 = technologyRequirementMapper.selectTechnologyRequirementByTechnologyName(technologyName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list1);
        //取记录总条数
        PageInfo<Technology> pageInfo = new PageInfo<>(list1);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Result update_requirement(TechnologyRequirement technologyRequirement) {
        int i = technologyRequirementMapper.updateRequirement(technologyRequirement);
        if (i==1){

            Result result = new Result();
            result.setStatus(200);
            result.setData("null");
            result.setMsg("ok");
            return  result;
        }
        return null;
    }


}
