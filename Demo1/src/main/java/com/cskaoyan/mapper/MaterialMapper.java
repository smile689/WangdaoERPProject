package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MaterialMapper {


    int deleteByPrimaryKey(@Param("ids") String[] materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByPrimaryKey();

    int updateByPrimaryKeySelective(@Param("materialId") String materialId, @Param("note") String note);

    int updateByPrimaryKey(Material record);
    //通过ID模糊搜索物料信息
    List<Material> selectByPrimaryId(String searchValue);
    //通过类型模糊搜索物料信息
    List<Material> selectByPrimarytype(String searchValue);

    Material findByMaterialId(@Param("materialId") String materialId);
}