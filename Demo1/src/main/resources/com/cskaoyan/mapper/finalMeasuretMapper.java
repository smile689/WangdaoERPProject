package com.cskaoyan.mapper;

import com.cskaoyan.bean.finalMeasuret;

public interface finalMeasuretMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(finalMeasuret record);

    int insertSelective(finalMeasuret record);

    finalMeasuret selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(finalMeasuret record);

    int updateByPrimaryKey(finalMeasuret record);
}