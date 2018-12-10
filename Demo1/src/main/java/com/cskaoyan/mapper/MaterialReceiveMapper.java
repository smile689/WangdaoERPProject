package com.cskaoyan.mapper;

import com.cskaoyan.bean.MaterialReceive;

import java.util.List;

public interface MaterialReceiveMapper {

    int deleteByPrimaryKey(String[] ids);

    int insert( MaterialReceive materialReceive);

    int insertSelective(MaterialReceive record);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);

    List<MaterialReceive> selectReceiveList();

}