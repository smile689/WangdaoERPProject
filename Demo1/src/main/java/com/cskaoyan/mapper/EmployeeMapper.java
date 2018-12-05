package com.cskaoyan.mapper;

import com.cskaoyan.bean.Employee;

public interface EmployeeMapper {
    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}