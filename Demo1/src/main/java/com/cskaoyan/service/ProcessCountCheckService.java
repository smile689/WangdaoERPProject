package com.cskaoyan.service;

import com.cskaoyan.Utils.EUDataGridResult;
import com.cskaoyan.bean.Vo.ProcessCountVo;
import com.cskaoyan.bean.ProcessCount;


public interface ProcessCountCheckService {

    int deleteByPrimaryKey(String Id);

    EUDataGridResult insert(ProcessCount record);

    int insertSelective(ProcessCount record);

    EUDataGridResult selectByPrimaryKey(String  Id);

    EUDataGridResult updateByPrimaryKeySelective(ProcessCountVo record);

    int updateByPrimaryKey(ProcessCountVo record);

    //分页显示界面
    EUDataGridResult getItemList(int age, int rows);


    //多选删除
    EUDataGridResult deleteByIds(String [] ids);

    //根据订单id 去查询成品计数
    EUDataGridResult selectByOrderId(String orderid);
}
