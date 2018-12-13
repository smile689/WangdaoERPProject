package com.cskaoyan.service;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.Work;
import com.cskaoyan.bean.pojo.PageShowResult;

/**
 * @Description: java类作用描述
 * @Author: zhoubin
 * @CreateDate: 2018/12/11 23:56
 * @需求:
 * @思路说明:
 */
public interface MaterialConsumeService {
    PageShowResult getList(Integer page, Integer rows);
    //插入
    int insertMaterialReceiveService(MaterialConsume materialConsume);
    //编辑
    int updateMaterialConsumeService(MaterialConsume materialConsume);
    //删除
    int deleteMaterialConsumeService(String[] ids);
    //更新note
    int updateMaterialConsumeSelective(String consumeId, String note);
    //物料消耗搜索
    PageShowResult searcMaterialConsume(String searchValue, Integer page, Integer rows);
    //物料消耗里workid搜索
    PageShowResult serachMaterialWorkId(Work work, Integer page, Integer rows);
    //物料消耗里物料ID搜索
    PageShowResult serachMateriaId(Material material, Integer page, Integer rows);
}
