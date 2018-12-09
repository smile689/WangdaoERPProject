package com.cskaoyan.service;

import com.cskaoyan.bean.Corder;
import com.cskaoyan.utils.JsonFindRet;

import java.util.List;

public interface CorderService {

    Corder findOrderById(String orderId);

    Integer countTotalNum();

    JsonFindRet<Corder> findOrders(Corder corder, Integer page, Integer rows);

    boolean addOrder(Corder corder);

    boolean updateOrder(Corder corder);

    boolean deleteOrder(String ids);

    boolean updateNote(Corder corder);

    List<Corder> findAll();
}
