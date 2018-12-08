package com.cskaoyan.mapper;

import com.cskaoyan.bean.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentMapper")
public interface DepartmentMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    int selectCount();

    List<Department> selectByLimitAndOffset();

    Department selectByName(String departmentName);

    Department selectOtherByName(Department department);

    int selectCountById(String departmentId);

    List<Department> selectByLimitAndOffsetAndId(String departmentId);

    int selectCountByName(String departmentName);

    List<Department> selectByLimitAndOffsetAndName(String departmentName);
}