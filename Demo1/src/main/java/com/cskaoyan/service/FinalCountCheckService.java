package com.cskaoyan.service;

import com.cskaoyan.Utils.EUDataGridResult;
import com.cskaoyan.bean.FinalCount;
import com.cskaoyan.bean.Vo.FinalCountVo;

import java.util.List;

public interface FinalCountCheckService {

    //分页显示 返回分页信息

     EUDataGridResult getItemList(int age,int rows);

    //根据主键删除
    int deleteByPrimaryKey(String fCountCheckId);

    //新增产品计数
    int insert(FinalCount record);

    //有选择的插入质量计数属性
    int insertSelective(FinalCount record);

    //根据主键查询
    FinalCount selectByPrimaryKey(String fCountCheckId);

    //根据主键有选择性的更新属性信息
    int updateByPrimaryKeySelective(FinalCount record);

    //根据主键更新所有属性信息
    int updateByPrimaryKey(FinalCount record);

    //查询所有的数据库里的质量计数信息
    List<FinalCountVo> selectAll();

    //根据订单id 去查询成品计数
    EUDataGridResult selectByOrderId(String orderid);

    //多选删除
    EUDataGridResult deleteByIds(String [] ids);
}
