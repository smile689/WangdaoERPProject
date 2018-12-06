package com.cskaoyan.mapper;

import com.cskaoyan.bean.UnqualityApply;

public interface UnqualityApplyMapper {
    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualityApply record);

    int insertSelective(UnqualityApply record);

    UnqualityApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByPrimaryKeySelective(UnqualityApply record);

    int updateByPrimaryKey(UnqualityApply record);
}