package com.cskaoyan.service;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.vo.FinalMeasuretVo;
import com.cskaoyan.bean.FinalMeasuret;

import java.util.List;

public interface FinalMeasuretService {

    int deleteByPrimaryKey(String fMeasureCheckId);

    EUDataGridResult insert(FinalMeasuret record);

    int insertSelective(FinalMeasuret record);

    EUDataGridResult selectByPrimaryKey(String fMeasureCheckId);

    EUDataGridResult updateByPrimaryKeySelective(FinalMeasuretVo record);

    int updateByPrimaryKey(FinalMeasuret record);

    //分页显示界面
    EUDataGridResult getItemList(int age, int rows);

    List<FinalMeasuretVo> selectAll();

    //多选删除
    EUDataGridResult deleteByIds(String [] ids);

    //根据订单id 去查询成品计数
    EUDataGridResult selectByOrderId(String orderid);

}
