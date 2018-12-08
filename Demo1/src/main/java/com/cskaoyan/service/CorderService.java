package com.cskaoyan.service;

import com.cskaoyan.bean.Corder;

import java.util.List;

public interface CorderService {

    public Corder findOrderById(String orderId);

    List<Corder> findOrders(String page, String rows);

    Integer countTotalNum();
}
