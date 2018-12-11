package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
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
    //获取物料收入信息
    PageShowResult getList(Integer page, Integer rows);
    //插入物料收入信息
    int insertMaterialReceiveService(MaterialReceive materialReceive,String materialId);
    //更新物料收入信息
    int updateMaterialReceiveService(MaterialReceive materialReceive,String materialId);
    //批量删除
    int deleteMaterialReceiveService(String[] ids);
    //通过物料收入ID模糊搜索
    PageShowResult searcMaterialReveice(String searchValue, Integer page, Integer rows);
    //通过物料收入里物料信息ID模糊搜索
    PageShowResult serachMaterialReceiveMaterialId(Material material, Integer page, Integer rows);
    //更新物料收备注
    int  updateMaterialReceiveSelective(String receiveId, String note);
}
