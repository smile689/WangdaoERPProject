package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalCount;

public interface FinalCountMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCount record);

    int insertSelective(FinalCount record);

    FinalCount selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCount record);

    int updateByPrimaryKey(FinalCount record);
}