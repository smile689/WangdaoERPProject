package com.cskaoyan.service;

import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.bean.Vo.UnqualifyApplyVo;

public interface UnqualifyApplyService {
    int deleteByPrimaryKey(String Id);

    EUDataGridResult insert(UnqualifyApplyVo record);

    int insertSelective(UnqualifyApplyVo record);

    EUDataGridResult selectByPrimaryKey(String  Id);

    EUDataGridResult updateByPrimaryKeySelective(UnqualifyApplyVo record);

    int updateByPrimaryKey(UnqualifyApplyVo record);

    //分页显示界面
    EUDataGridResult getItemList(int age, int rows);


    //多选删除
    EUDataGridResult deleteByIds(String [] ids);

    //根据订单id 去查询成品计数
    EUDataGridResult selectByOrderId(String orderid);

    EUDataGridResult selectByProductName(String productname);
}
