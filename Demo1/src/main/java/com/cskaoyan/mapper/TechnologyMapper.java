package com.cskaoyan.mapper;

import com.cskaoyan.bean.Technology;

import java.util.List;

public interface TechnologyMapper {

    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    int updateByPrimaryKey(Technology record);

    List<Technology> selectAll();
}