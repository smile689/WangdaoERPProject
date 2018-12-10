package com.cskaoyan.mapper;

import com.cskaoyan.bean.ProcessCount;

public interface ProcessCountMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCount record);

    int insertSelective(ProcessCount record);

    ProcessCount selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCount record);

    int updateByPrimaryKey(ProcessCount record);
}