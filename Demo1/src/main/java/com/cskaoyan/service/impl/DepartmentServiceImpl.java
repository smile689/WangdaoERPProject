package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
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
    public PageHelper<Department> findAllDepartments(String currentPageNum, String perPageNum) {
        int totalRecordsNum = departmentMapper.selectCount();
        PageHelper<Department> pageHelper = new PageHelper<> (totalRecordsNum, Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        int limit = Integer.parseInt(perPageNum);
        int offset= (Integer.parseInt(currentPageNum) - 1) * limit;
        HashMap hashMap = new HashMap();
        hashMap.put("limit", limit);
        hashMap.put("offset", offset);
        List<Department> departmentList = departmentMapper.selectByLimitAndOffset(hashMap);
        pageHelper.setRecords(departmentList);
        return pageHelper;
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
        int i = 0;
        for (; i < ids.length; i++) {
            int deleteByPrimaryKey = departmentMapper.deleteByPrimaryKey(ids[i]);
            if (deleteByPrimaryKey != 1) {
                break;
            }
        }
        if (i == ids.length) {
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
    public PageHelper<Department> findDepartmentById(String currentPageNum, String perPageNum, String departmentId) {
        int totalRecordsNum = departmentMapper.selectCountById(departmentId);
        PageHelper<Department> pageHelper = new PageHelper<> (totalRecordsNum, Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        int limit = Integer.parseInt(perPageNum);
        int offset= (Integer.parseInt(currentPageNum) - 1) * limit;
        HashMap hashMap = new HashMap();
        hashMap.put("limit", limit);
        hashMap.put("offset", offset);
        hashMap.put("departmentId", departmentId);
        List<Department> departmentList = departmentMapper.selectByLimitAndOffsetAndId(hashMap);
        pageHelper.setRecords(departmentList);
        return pageHelper;
    }

    @Override
    public PageHelper<Department> findDepartmentByName(String currentPageNum, String perPageNum, String departmentName) {
        int totalRecordsNum = departmentMapper.selectCountByName(departmentName);
        PageHelper<Department> pageHelper = new PageHelper<> (totalRecordsNum, Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        int limit = Integer.parseInt(perPageNum);
        int offset= (Integer.parseInt(currentPageNum) - 1) * limit;
        HashMap hashMap = new HashMap();
        hashMap.put("limit", limit);
        hashMap.put("offset", offset);
        hashMap.put("departmentName", departmentName);
        List<Department> departmentList = departmentMapper.selectByLimitAndOffsetAndName(hashMap);
        pageHelper.setRecords(departmentList);
        return pageHelper;
    }
}
