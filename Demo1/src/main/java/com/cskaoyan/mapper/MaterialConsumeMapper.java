package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialConsume;
import com.cskaoyan.bean.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialConsumeMapper {
    //删除
    int deleteByPrimaryKey(@Param("ids") String[] ids);
    //插入物料消耗数据
    int insert(MaterialConsume materialConsume);

    int insertSelective(MaterialConsume record);

    MaterialConsume selectByPrimaryKey(String consumeId);
    //更新note
    int updateByPrimaryKeySelective(@Param(("consumeId")) String consumeId, @Param("note") String note);
    //编辑
    int updateByPrimaryKey(MaterialConsume materialConsume);
    //查询物料消耗列表
    List<MaterialConsume> selectConsumeList();
    //物料消耗ID搜索
    List<MaterialConsume> selectConsumeId(String searchValue);
    //工作ID搜索
    List<MaterialConsume> selectWorkId(@Param("work") Work work);
    //物料消耗里物料ID搜索
    List<MaterialConsume> selectMaterialId(@Param("material") Material material);
}