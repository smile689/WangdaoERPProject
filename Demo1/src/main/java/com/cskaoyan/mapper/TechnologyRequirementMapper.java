package com.cskaoyan.mapper;

import com.cskaoyan.bean.Technology;
import com.cskaoyan.bean.TechnologyRequirement;

import java.util.List;

public interface TechnologyRequirementMapper {

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateRequirement(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

    List<TechnologyRequirement> selectAll(Integer page, Integer rows, TechnologyRequirement technologyRequirement);

    int deleteByPrimaryKey(String[] ids);



    List<Technology> selectTechnologyRequirementByTechnologyRequirementId(String technologyRequirementId);

    List<Technology> selectTechnologyRequirementByTechnologyName(String technologyName);
}