package com.cskaoyan.mapper;

import com.cskaoyan.bean.TechnologyPlan;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);
}