package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;
import com.cskaoyan.bean.MaterialReceive;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialReceiveMapper {
    //物料收入批量删除
    int deleteByPrimaryKey(@Param("ids") String[] ids);
    //物料收入新增
    int insert(MaterialReceive materialReceive);

    int insertSelective(MaterialReceive record);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> selectReceiveList();
    //物料收入ID模糊搜索
    List<MaterialReceive> selectByPrimaryId(String searchValue);
    //物料收入里物料信息ID搜索
    List<MaterialReceive> selectByPrimaryMaterialId(@Param("material") Material material);

    int updateByReceiveIdSelective(@Param("receiveId") String receiveId, @Param("note") String note);
}