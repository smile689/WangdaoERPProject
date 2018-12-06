package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalMeasuret;

public interface FinalMeasuretMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuret record);

    int insertSelective(FinalMeasuret record);

    FinalMeasuret selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuret record);

    int updateByPrimaryKey(FinalMeasuret record);
}