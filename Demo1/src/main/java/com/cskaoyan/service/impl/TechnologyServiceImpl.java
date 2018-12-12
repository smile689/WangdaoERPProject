package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.controller.JsonResult.EUDataGridResult;
import com.cskaoyan.controller.JsonResult.Result;
import com.cskaoyan.mapper.TechnologyMapper;
import com.cskaoyan.service.TechnologyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
@Autowired
    TechnologyMapper technologyMapper;
    @Override
    public Technology get(String technologyId) {
        Technology technology = technologyMapper.selectByPrimaryKey(technologyId);
        return technology;
    }
    @Override
    public EUDataGridResult getList(Integer page, Integer rows, Technology technology) {
        //查询工艺列表
        //分页参数
        PageHelper.startPage(page,rows);
       List<Technology> technologyList= technologyMapper.selectAll();
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(technologyList);
        //取总条数
        PageInfo<Technology> technologyPageInfo = new PageInfo<>(technologyList);
        euDataGridResult.setTotal(technologyPageInfo.getTotal());
        return euDataGridResult;

    }

    @Override
    public Result insert(Technology technology) {

        int insert = technologyMapper.insert(technology);
        if (insert==1){
            Result result = new Result();
            result.setMsg("ok");
            result.setStatus(200);
            result.setData(null);
            return result;
        }
        else {
            return null;
        }

    }
    @Override
    public Result deleteById(String[] ids) {
        int i = technologyMapper.deleteByPrimaryKey(ids);
        if (i>=1){
            Result result = new Result();
            result.setMsg("ok");
            result.setStatus(200);
            result.setData(null);
            return result;
        }
        else{

            return null;
        }
    }

    @Override
    public Result updateAll(Technology technology) {
        int i = technologyMapper.updateByPrimaryKey(technology);
        Result result = new Result();

        if (i==1){
            result.setMsg("ok");
            result.setStatus(200);
            result.setData(null);
            return result;
        }
        else {
           result.setMsg("更新失败");
           return result;

        }

    }

    @Override
    public EUDataGridResult search_technology_by_technologyId(Integer page, Integer rows, String technologyId) {

        PageHelper.startPage(page, rows);
        List<Technology> list = technologyMapper.selectTechnologyByTechnologyId(technologyId);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public EUDataGridResult search_technology_by_technologyName(Integer page, Integer rows, String technologyName) {
        PageHelper.startPage(page, rows);
        List<Technology> list = technologyMapper.selectTechnologyByTechnologyName(technologyName);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Technology> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public List<Technology> search() {
        return   technologyMapper.selectByTechnologyName();

    }
}
