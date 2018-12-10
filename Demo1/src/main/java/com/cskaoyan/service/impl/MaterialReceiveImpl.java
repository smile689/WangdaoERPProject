package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.mapper.MaterialReceiveMapper;
import com.cskaoyan.pojo.PageShowResult;
import com.cskaoyan.service.MaterialReceiveService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/10 20:33
 * @需求:
 * @思路说明:
 */
@Service
public class MaterialReceiveImpl implements MaterialReceiveService {

    @Autowired
    MaterialReceiveMapper materialReceiveMapper;

    @Override
    public PageShowResult getList(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<MaterialReceive> materialReceives = materialReceiveMapper.selectReceiveList();
        PageShowResult pageShowResult = new PageShowResult();
        pageShowResult.setRows(materialReceives);
        PageInfo<MaterialReceive> materialReceivePageInfo = new PageInfo<>(materialReceives);
        pageShowResult.setTotal(materialReceivePageInfo.getTotal());
        return pageShowResult;
    }

    @Override
    public int insertMaterialReceiveService(MaterialReceive materialReceive ,String materialId) {

        Material material = new Material();
        material.setMaterialId(materialId);
        materialReceive.setMaterial(material);
        return materialReceiveMapper.insert(materialReceive);
    }

    @Override
    public int updateMaterialReceiveService(MaterialReceive materialReceive,String materialId) {
        Material material = new Material();
        material.setMaterialId(materialId);
        materialReceive.setMaterial(material);
        return materialReceiveMapper.updateByPrimaryKey(materialReceive);
    }

    @Override
    public int deleteMaterialReceiveService(String[] ids) {
        return materialReceiveMapper.deleteByPrimaryKey(ids);
    }
}
