package com.cskaoyan.service;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.vo.ProcessMeasuretVo;


public interface ProcessMeasuretService {


    int deleteByPrimaryKey(String Id);

    EUDataGridResult insert(ProcessMeasuretVo record);

    int insertSelective(ProcessMeasuretVo record);

    EUDataGridResult selectByPrimaryKey(String  Id);

    EUDataGridResult updateByPrimaryKeySelective(ProcessMeasuretVo record);

    int updateByPrimaryKey(ProcessMeasuretVo record);

    //分页显示界面
    EUDataGridResult getItemList(int age, int rows);


    //多选删除
    EUDataGridResult deleteByIds(String [] ids);

    //根据订单id 去查询成品计数
    EUDataGridResult selectByOrderId(String orderid);
}
