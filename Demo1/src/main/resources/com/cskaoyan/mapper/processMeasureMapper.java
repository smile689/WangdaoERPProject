package com.cskaoyan.mapper;

import com.cskaoyan.bean.processMeasure;

public interface processMeasureMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(processMeasure record);

    int insertSelective(processMeasure record);

    processMeasure selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(processMeasure record);

    int updateByPrimaryKey(processMeasure record);
}