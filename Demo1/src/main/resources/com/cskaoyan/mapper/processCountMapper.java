package com.cskaoyan.mapper;

import com.cskaoyan.bean.processCount;

public interface processCountMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(processCount record);

    int insertSelective(processCount record);

    processCount selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(processCount record);

    int updateByPrimaryKey(processCount record);
}