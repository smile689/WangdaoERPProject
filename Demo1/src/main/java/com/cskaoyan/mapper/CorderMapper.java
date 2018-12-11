package com.cskaoyan.mapper;

import com.cskaoyan.bean.Corder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CorderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Corder record);

    Corder selectByPrimaryKey(String orderId);

    int updateByPrimaryKey(Corder record);

    List<Corder> selectByPage(@Param("corder") Corder corder);

    Integer countTotalRecords();

    List<Corder> selectAll();
}