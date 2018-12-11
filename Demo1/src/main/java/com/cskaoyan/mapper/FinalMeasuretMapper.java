package com.cskaoyan.mapper;


import com.cskaoyan.bean.FinalMeasuret;
import com.cskaoyan.bean.Vo.FinalMeasuretVo;

import java.util.List;

public interface FinalMeasuretMapper {
    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuret record);

    int insertSelective(FinalMeasuret record);

    FinalMeasuretVo selectByPrimaryKey(String fMeasureCheckId);

    int updateByPrimaryKeySelective(FinalMeasuret record);

    int updateByPrimaryKey(FinalMeasuret record);

    //查询所有的产品计量
    List<FinalMeasuretVo>  selectAll();

    //多选删除
    boolean deleteByIds(String [] ids);

    //根据id搜索
    List<FinalMeasuretVo>  selectByOrderId(String orderid);
}