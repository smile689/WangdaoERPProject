package com.cskaoyan.mapper;


import com.cskaoyan.bean.TechnologyPlan;

import java.util.List;

public interface TechnologyPlanMapper {

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);

    List<TechnologyPlan> selectAll();

    int deleteByPrimaryKey(String[] ids);

    List<TechnologyPlan> selectByTechnologyName(String technologyName);

    List<TechnologyPlan> selectByTechnologyPlanId(String technologyPlanId);

    List<TechnologyPlan> searchTechnologyPlanId();
}