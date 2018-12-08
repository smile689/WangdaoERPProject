package com.cskaoyan.mapper;

import com.cskaoyan.bean.Corder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CorderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Corder record);

    int insertSelective(Corder record);

    Corder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Corder record);

    int updateByPrimaryKey(Corder record);

    List<Corder> selectByPage(@Param("limit") int limit, @Param("offset")int offset);

    Integer countTotalRecords();
}