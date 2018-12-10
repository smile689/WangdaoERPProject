package com.cskaoyan.service;

import com.cskaoyan.bean.MaterialReceive;
import com.cskaoyan.pojo.PageShowResult;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/10 20:32
 * @需求:
 * @思路说明:
 */
public interface MaterialReceiveService {
    PageShowResult getList(Integer page, Integer rows);

    int insertMaterialReceiveService(MaterialReceive materialReceive,String materialId);

    int updateMaterialReceiveService(MaterialReceive materialReceive,String materialId);

    int deleteMaterialReceiveService(String[] ids);
}
