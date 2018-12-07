package com.cskaoyan.service.impl;

import com.cskaoyan.bean.EUDateGridResult;
import com.cskaoyan.bean.FinalCount;
import com.cskaoyan.mapper.FinalCountMapper;
import com.cskaoyan.service.FinalCountCheckService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCountCheckImp implements FinalCountCheckService {

    //注入mapper接口
    @Autowired
    FinalCountMapper finalCountMapper;


    @Override
    public EUDateGridResult getItemList(int page, int rows) {

        //分页处理
        PageHelper.startPage(page,rows);

        //分页对象
        EUDateGridResult result = new EUDateGridResult();

        List<FinalCount> list = finalCountMapper.selectAll();

        //将list数据存入result对象
        result.setRows(list);

        //查询页面的数目
        PageInfo<FinalCount> pageInfo = new PageInfo<>(list);
        //将查询到的数目添加到result对象中
        result.setTotal(pageInfo.getTotal());

        //将页面信息返回到控制器
        return result;
    }


}
