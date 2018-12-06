package com.cskaoyan.mapper;

import com.cskaoyan.bean.ProcessMeasure;

public interface ProcessMeasureMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasure record);

    int insertSelective(ProcessMeasure record);

    ProcessMeasure selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasure record);

    int updateByPrimaryKey(ProcessMeasure record);
}