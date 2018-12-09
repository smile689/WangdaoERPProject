package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Corder;
import com.cskaoyan.mapper.CorderMapper;
import com.cskaoyan.service.CorderService;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CorderServiceImpl implements CorderService {

    @Autowired
    CorderMapper corderMapper;

    @Transactional(readOnly = true)
    @Override
    public Corder findOrderById(String orderId) {
        return corderMapper.selectByPrimaryKey(orderId);
    }

    @Transactional(readOnly = true)
    @Override
    public Integer countTotalNum() {
        return corderMapper.countTotalRecords();
    }

    @Transactional(readOnly = true)
    @Override
    public JsonFindRet<Corder> findOrders(Corder corder, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Corder> corderList = corderMapper.selectByPage(corder);
        PageInfo<Corder> corderPageInfo=new PageInfo<>(corderList);
        JsonFindRet<Corder> jsonFindRet=new JsonFindRet<>();
        jsonFindRet.setTotal(corderPageInfo.getTotal());
        jsonFindRet.setRows(corderList);
        return jsonFindRet;
    }

    @Transactional
    @Override
    public boolean addOrder(Corder corder) {
        return corderMapper.insert(corder)==1;
    }

    @Transactional
    @Override
    public boolean updateOrder(Corder corder) {
        return corderMapper.updateByPrimaryKey(corder)==1;
    }

    @Transactional
    @Override
    public boolean deleteOrder(String ids) {
        String[] idList = ids.split(",");
        for (String idToDelete: idList) {
            if(corderMapper.deleteByPrimaryKey(idToDelete)!=1){
                return false;
            }
        }
        return true;
    }

    @Transactional
    @Override
    public boolean updateNote(Corder corder) {
        Corder orderToUpdateNote = corderMapper.selectByPrimaryKey(corder.getOrderId());
        orderToUpdateNote.setNote(corder.getNote());
        return corderMapper.updateByPrimaryKey(orderToUpdateNote)==1;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Corder> findAll() {
        return corderMapper.selectAll();
    }


}
