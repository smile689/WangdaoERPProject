package com.cskaoyan.mapper;

import com.cskaoyan.bean.Material;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MaterialMapper {


    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByPrimaryKey();

    int updateByPrimaryKeySelective(@Param("materialId") String materialId, @Param("note") String note);

    int updateByPrimaryKey(Material record);

    List<Material> selectByPrimaryId(String searchValue);

    List<Material> selectByPrimarytype(String searchValue);

}