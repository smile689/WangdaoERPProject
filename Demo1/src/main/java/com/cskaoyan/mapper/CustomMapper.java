package com.cskaoyan.mapper;

import com.cskaoyan.bean.Custom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKey(Custom record);

    List<Custom> selectByPage(@Param("custom")Custom custom);

    Integer countTotalRecords(@Param("custom") Custom custom);
}