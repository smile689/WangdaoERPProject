package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.pojo.PageShowResult;
import com.cskaoyan.mapper.MaterialConsumeMapper;
import com.cskaoyan.service.MaterialConsumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/11 23:56
 * @需求:
 * @思路说明:
 */
@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;

    @Override
    public PageShowResult getList(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectConsumeList();
        PageShowResult pageShowResult = new PageShowResult();
        pageShowResult.setRows(materialConsumes);
        PageInfo<MaterialConsume> materialReceivePageInfo = new PageInfo<>(materialConsumes);
        pageShowResult.setTotal(materialReceivePageInfo.getTotal());
        return pageShowResult;
    }

    @Override
    public int insertMaterialReceiveService(MaterialConsume materialConsume) {
        int insert = materialConsumeMapper.insert(materialConsume);
        return insert;
    }

    @Override
    public int updateMaterialConsumeService(MaterialConsume materialConsume) {
        return materialConsumeMapper.updateByPrimaryKey(materialConsume);
    }

    @Override
    public int deleteMaterialConsumeService(String[] ids) {
        return materialConsumeMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int updateMaterialConsumeSelective(String consumeId, String note) {
        return materialConsumeMapper.updateByPrimaryKeySelective(consumeId,note);
    }

    @Override
    public PageShowResult searcMaterialConsume(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectConsumeId(searchValue);
        PageShowResult pageShowResult = new PageShowResult();
        pageShowResult.setRows(materialConsumes);
        PageInfo<MaterialConsume> materialReceivePageInfo = new PageInfo<>(materialConsumes);
        pageShowResult.setTotal(materialReceivePageInfo.getTotal());
        return pageShowResult;
    }

    @Override
    public PageShowResult serachMaterialWorkId(Work work, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectWorkId(work);
        PageShowResult pageShowResult = new PageShowResult();
        pageShowResult.setRows(materialConsumes);
        PageInfo<MaterialConsume> materialReceivePageInfo = new PageInfo<>(materialConsumes);
        pageShowResult.setTotal(materialReceivePageInfo.getTotal());
        return pageShowResult;
    }

    @Override
    public PageShowResult serachMateriaId(Material material, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<MaterialConsume> materialConsumes = materialConsumeMapper.selectMaterialId(material);
        PageShowResult pageShowResult = new PageShowResult();
        pageShowResult.setRows(materialConsumes);
        PageInfo<MaterialConsume> materialReceivePageInfo = new PageInfo<>(materialConsumes);
        pageShowResult.setTotal(materialReceivePageInfo.getTotal());
        return pageShowResult;
    }
}
