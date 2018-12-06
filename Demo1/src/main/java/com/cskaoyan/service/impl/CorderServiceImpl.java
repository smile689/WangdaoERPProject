package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Corder;
import com.cskaoyan.mapper.CorderMapper;
import com.cskaoyan.service.CorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorderServiceImpl implements CorderService {

    @Autowired
    CorderMapper corderMapper;

    @Override
    public Corder findOrderById(String orderId) {
        return corderMapper.selectByPrimaryKey(orderId);
    }
}
