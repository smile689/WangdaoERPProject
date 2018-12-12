package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.utils.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangGuoming
 * created on 2018/12/6
 */
@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    @Qualifier("departmentMapper")
    DepartmentMapper departmentMapper;

    @Override
    public EUDataGridResult findAllDepartments(String currentPageNum, String perPageNum) {
        int selectCount = departmentMapper.selectCount();
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        List<Department> departmentList = departmentMapper.select();
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(departmentList);
        euDataGridResult.setTotal(selectCount);
        euDataGridResult.setStatus(200);
        return euDataGridResult;
    }

    @Override
    public int insertOneDepartment(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public boolean isDepartmentExistById(Department department) {
        boolean ret = false;
        Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(department.getDepartmentId());
        if (selectByPrimaryKey != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean isDepartmentExistByName(Department department) {
        boolean ret = false;
        Department selectByPrimaryKey = departmentMapper.selectByName(department.getDepartmentName());
        if (selectByPrimaryKey != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean deleteDepartmentsByIds(String[] ids) {
        boolean ret = false;
        int deleteByPrimaryKeys = departmentMapper.deleteByPrimaryKeys(ids);
        if (deleteByPrimaryKeys == ids.length) {
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean isOtherDepartmentExistByName(Department department) {
        boolean ret = false;
        Department selectByPrimaryKey = departmentMapper.selectOtherByName(department);
        if (selectByPrimaryKey != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public int updateOneDepartment(Department department) {
        return departmentMapper.updateByPrimaryKey(department);
    }

    @Override
    public int updateOneDepartmentNote(Department department) {
        Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(department.getDepartmentId());
        department.setDepartmentName(selectByPrimaryKey.getDepartmentName());
        return departmentMapper.updateByPrimaryKey(department);
    }

    @Override
    public EUDataGridResult findOneDepartmentById(String currentPageNum, String perPageNum, String departmentId) {
        int selectCount = departmentMapper.selectCountById(departmentId);
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(departmentId);
        List<Department> departmentList = new ArrayList<>();
        departmentList.add(selectByPrimaryKey);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(departmentList);
        euDataGridResult.setTotal(selectCount);
        euDataGridResult.setStatus(200);
        return euDataGridResult;
    }

    @Override
    public EUDataGridResult findDepartmentsByNames(String currentPageNum, String perPageNum, String departmentName) {
        int selectCount = departmentMapper.selectCountByName(departmentName);
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        List<Department> departmentList = departmentMapper.selectByNames(departmentName);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(departmentList);
        euDataGridResult.setTotal(selectCount);
        euDataGridResult.setStatus(200);
        return euDataGridResult;
    }
}
