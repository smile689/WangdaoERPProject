package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.utils.PageHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author WangGuoming
 * created on 2018/12/6
 */
public interface DepartmentService {
    PageHelper<Department> findAllDepartments(String currentPageNum, String perPageNum);

    int insertOneDepartment(Department department);

    boolean isDepartmentExistById(Department department);

    boolean isDepartmentExistByName(Department department);

    boolean deleteDepartmentsByIds(String[] ids);

    boolean isOtherDepartmentExistByName(Department department);

    int updateOneDepartment(Department department);

    int updateOneDepartmentNote(Department department);

    PageHelper<Department> findDepartmentById(String currentPageNum, String perPageNum, String departmentId);

    PageHelper<Department> findDepartmentByName(String currentPageNum, String perPageNum, String departmentName);
}
