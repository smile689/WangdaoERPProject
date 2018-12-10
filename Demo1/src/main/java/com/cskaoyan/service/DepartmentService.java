package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.utils.EUDataGridResult;

/**
 * @author WangGuoming
 * created on 2018/12/6
 */
public interface DepartmentService {
    EUDataGridResult findAllDepartments(String currentPageNum, String perPageNum);

    int insertOneDepartment(Department department);

    boolean isDepartmentExistById(Department department);

    boolean isDepartmentExistByName(Department department);

    boolean deleteDepartmentsByIds(String[] ids);

    boolean isOtherDepartmentExistByName(Department department);

    int updateOneDepartment(Department department);

    int updateOneDepartmentNote(Department department);

    EUDataGridResult findOneDepartmentById(String currentPageNum, String perPageNum, String departmentId);

    EUDataGridResult findDepartmentsByNames(String currentPageNum, String perPageNum, String departmentName);
}
