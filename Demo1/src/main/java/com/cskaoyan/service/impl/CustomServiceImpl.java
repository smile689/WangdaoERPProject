package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.mapper.CustomMapper;
import com.cskaoyan.service.CustomService;
import com.cskaoyan.utils.JsonFindRet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {

    @Autowired
    CustomMapper customMapper;

    @Transactional(readOnly = true)
    @Override
    public Custom findCustomById(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Transactional(readOnly = true)
    @Override
    public JsonFindRet<Custom> findCustoms(Custom custom, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<Custom> customList = customMapper.selectByPage(custom);
        PageInfo<Custom> customPageInfo=new PageInfo<>(customList);
        System.out.println(customList.size());
        JsonFindRet<Custom> jsonFindRet=new JsonFindRet<>();
        jsonFindRet.setTotal(customPageInfo.getTotal());
        jsonFindRet.setRows(customList);
        return jsonFindRet;
    }

    @Transactional
    @Override
    public boolean addCustom(Custom custom) {
        return customMapper.insert(custom)==1;
    }

    @Transactional
    @Override
    public boolean updateCustom(Custom custom) {
        return customMapper.updateByPrimaryKey(custom)==1;
    }

    @Transactional
    @Override
    public boolean deleteCustom(String ids) {
        String[] idList = ids.split(",");
        for (String idToDelete: idList) {
            if(customMapper.deleteByPrimaryKey(idToDelete)!=1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateNote(Custom custom) {
        Custom customToUpdateNote = customMapper.selectByPrimaryKey(custom.getCustomId());
        customToUpdateNote.setNote(custom.getNote());
        return customMapper.updateByPrimaryKey(customToUpdateNote)==1;
    }
}
