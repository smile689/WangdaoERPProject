package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Manufacture;
import com.cskaoyan.mapper.ManufactureMapper;
import com.cskaoyan.service.ManufactureService;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManufactureServiceImpl implements ManufactureService {

    @Autowired
    ManufactureMapper manufactureMapper;

    @Transactional(readOnly = true)
    @Override
    public Manufacture findManufactureById(String manufactureSn) {
        return manufactureMapper.selectByPrimaryKey(manufactureSn);
    }

    @Transactional(readOnly = true)
    @Override
    public JsonFindRet<Manufacture> findManufactures(Manufacture manufacture, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Manufacture> manufactureList = manufactureMapper.selectByPage(manufacture);
        PageInfo<Manufacture> manufacturePageInfo=new PageInfo<>(manufactureList);
        JsonFindRet<Manufacture> jsonFindRet=new JsonFindRet<>();
        jsonFindRet.setTotal(manufacturePageInfo.getTotal());
        jsonFindRet.setRows(manufactureList);
        return jsonFindRet;
    }

    @Transactional
    @Override
    public boolean addManufacture(Manufacture manufacture) {
        return manufactureMapper.insert(manufacture)==1;
    }

    @Transactional
    @Override
    public boolean updateManufacture(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKey(manufacture)==1;
    }

    @Transactional
    @Override
    public boolean deleteManufacture(String ids) {
        String[] split = ids.split(",");
        for (String id:split) {
            if(manufactureMapper.deleteByPrimaryKey(id)!=1){
                return false;
            }
        }
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Manufacture> findAll() {
        return manufactureMapper.selectAll();
    }
}
