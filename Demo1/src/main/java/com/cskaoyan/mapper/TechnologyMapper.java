package com.cskaoyan.mapper;

import com.cskaoyan.bean.Technology;

import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String[] ids);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);


    List<Technology> selectAll();

    List<Technology> selectTechnologyByTechnologyId(String technologyId);

    List<Technology> selectTechnologyByTechnologyName(String technology);


    List<Technology> selectByTechnologyName();
}