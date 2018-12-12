package com.cskaoyan.mapper;

import com.cskaoyan.bean.ProcessCount;
import com.cskaoyan.bean.vo.ProcessCountVo;

import java.util.List;

public interface ProcessCountMapper {
    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCount record);

    int insertSelective(ProcessCount record);

    ProcessCountVo selectByPrimaryKey(String pCountCheckId);

    int updateByPrimaryKeySelective(ProcessCount record);

    int updateByPrimaryKey(ProcessCount record);

    //查询所有的产品计量
    List<ProcessCountVo> selectAll();

    //多选删除
    boolean deleteByIds(String [] ids);

    //根据id搜索
    List<ProcessCount>  selectByOrderId(String orderid);
}