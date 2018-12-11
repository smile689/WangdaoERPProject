package com.cskaoyan.mapper;

import com.cskaoyan.bean.FinalCount;
import com.cskaoyan.bean.Vo.FinalCountVo;

import java.util.List;

public interface FinalCountMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCount record);

    int insertSelective(FinalCount record);

    FinalCountVo selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCount record);

    int updateByPrimaryKey(FinalCount record);

    List<FinalCountVo> selectAll();

    List<FinalCountVo>  selectByOrderId(String orderid);

    boolean deleteByIds(String [] ids);

}