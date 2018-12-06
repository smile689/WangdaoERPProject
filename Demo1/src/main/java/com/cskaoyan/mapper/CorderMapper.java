package com.cskaoyan.mapper;

import com.cskaoyan.bean.Corder;

public interface CorderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Corder record);

    int insertSelective(Corder record);

    Corder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Corder record);

    int updateByPrimaryKey(Corder record);
}