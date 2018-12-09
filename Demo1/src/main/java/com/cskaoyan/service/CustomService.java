package com.cskaoyan.service;

import com.cskaoyan.bean.Custom;
import com.cskaoyan.utils.JsonFindRet;

import java.util.List;

public interface CustomService {

    Custom findCustomById(String customId);

    JsonFindRet<Custom> findCustoms(Custom custom, Integer page, Integer rows);

    boolean addCustom(Custom custom);

    boolean updateCustom(Custom custom);

    boolean deleteCustom(String ids);

    boolean updateNote(Custom custom);

    List<Custom> findAll();
}
