package com.cskaoyan.mapper;

import com.cskaoyan.bean.ProcessMeasure;
import com.cskaoyan.bean.Vo.ProcessMeasuretVo;

import java.util.List;

public interface ProcessMeasureMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasure record);

    int insertSelective(ProcessMeasure record);

    ProcessMeasuretVo selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasure record);

    int updateByPrimaryKey(ProcessMeasure record);

    //查询所有的产品计量
    List<ProcessMeasuretVo> selectAll();

    //多选删除
    boolean deleteByIds(String [] ids);

    //根据id搜索
    List<ProcessMeasure>  selectByOrderId(String orderid);
}