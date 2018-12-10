package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Material;
import com.cskaoyan.mapper.MaterialMapper;
import com.cskaoyan.pojo.PageShowResult;
import com.cskaoyan.service.MaterialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/6 11:43
 * @需求:
 * @思路说明:
 */
@Service
public class MaterialServiceimpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;



    @Override
    public PageShowResult getList(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);

        List<Material> materials = materialMapper.selectByPrimaryKey();
        PageShowResult pageShowResult = new PageShowResult();
        pageShowResult.setRows(materials);
        PageInfo<Material> materialPageInfo = new PageInfo<>(materials);
        pageShowResult.setTotal(materialPageInfo.getTotal());
        return pageShowResult;
    }

    @Override
    public int insertMaterialService(Material material) {
        return materialMapper.insert(material);
    }

    @Override
    public int updateMaterialService(Material material) {
        return materialMapper.updateByPrimaryKey(material);
    }

   @Override
    public int deleteMaterialService(String materialId) {
        return materialMapper.deleteByPrimaryKey(materialId);
    }

    /**
     * 更新备注信息
     * @param materialId
     * @param note
     * @return
     */
    @Override
    public int updateMaterialServiceSelective(String materialId, String note) {
        return materialMapper.updateByPrimaryKeySelective(materialId,note);
    }

    @Override
    public PageShowResult searcMaterial(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Material> materials = materialMapper.selectByPrimaryId(searchValue);
        PageShowResult pageShowResult = new PageShowResult();
        pageShowResult.setRows(materials);
        PageInfo<Material> materialPageInfo = new PageInfo<>(materials);
        pageShowResult.setTotal(materialPageInfo.getTotal());
        return pageShowResult;
    }

    @Override
    public PageShowResult searcMaterialtype(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Material> materials = materialMapper.selectByPrimarytype(searchValue);
        PageShowResult pageShowResult = new PageShowResult();
        pageShowResult.setRows(materials);
        PageInfo<Material> materialPageInfo = new PageInfo<>(materials);
        pageShowResult.setTotal(materialPageInfo.getTotal());
        return pageShowResult;
    }
}
