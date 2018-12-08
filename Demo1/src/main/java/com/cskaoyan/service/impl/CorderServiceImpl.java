package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Corder;
import com.cskaoyan.mapper.CorderMapper;
import com.cskaoyan.service.CorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorderServiceImpl implements CorderService {

    @Autowired
    CorderMapper corderMapper;

    @Override
    public Corder findOrderById(String orderId) {
        return corderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public List<Corder> findOrders(String page, String rows) {
        int limit=Integer.parseInt(rows);
        int pageIndex=Integer.parseInt(page);
        int offset=(pageIndex-1)*limit;
        return corderMapper.selectByPage(limit, offset);
    }

    @Override
    public Integer countTotalNum() {
        return corderMapper.countTotalRecords();
    }


}
