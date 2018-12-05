package com.cskaoyan.mapper;

import com.cskaoyan.bean.Department;

public interface DepartmentMapper {
    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}