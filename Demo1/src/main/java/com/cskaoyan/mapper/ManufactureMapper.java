package com.cskaoyan.mapper;

import com.cskaoyan.bean.Manufacture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKey(Manufacture record);

    List<Manufacture> selectByPage(@Param("manufacture")Manufacture manufacture);

    List<Manufacture> selectAll();
}