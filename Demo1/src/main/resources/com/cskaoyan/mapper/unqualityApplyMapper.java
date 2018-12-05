package com.cskaoyan.mapper;

import com.cskaoyan.bean.unqualityApply;

public interface unqualityApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(unqualityApply record);

    int insertSelective(unqualityApply record);

    unqualityApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(unqualityApply record);

    int updateByPrimaryKey(unqualityApply record);
}