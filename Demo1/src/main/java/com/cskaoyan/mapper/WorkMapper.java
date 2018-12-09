package com.cskaoyan.mapper;

import com.cskaoyan.bean.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(String workId);

    int insert(Work record);

    Work selectByPrimaryKey(String workId);

    int updateByPrimaryKey(Work record);

    List<Work> selectByPage(@Param("work")Work work);

    List<Work> selectAll();
}