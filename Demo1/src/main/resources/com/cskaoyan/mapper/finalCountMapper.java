package com.cskaoyan.mapper;

import com.cskaoyan.bean.finalCount;

public interface finalCountMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(finalCount record);

    int insertSelective(finalCount record);

    finalCount selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(finalCount record);

    int updateByPrimaryKey(finalCount record);
}