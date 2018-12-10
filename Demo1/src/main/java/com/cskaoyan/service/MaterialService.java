package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
import com.cskaoyan.pojo.PageShowResult;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/6 11:43
 * @需求:
 * @思路说明:
 */
public interface MaterialService {

    PageShowResult getList(Integer page, Integer rows);

    int insertMaterialService(Material material);

    int updateMaterialService(Material material);

    int deleteMaterialService(String materialId);

    int updateMaterialServiceSelective(String materialId, String note);
}
