package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.utils.EmployeeOV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangGuoming
 * created on 2018/12/8
 */
@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    @Qualifier("employeeMapper")
    EmployeeMapper employeeMapper;

    @Autowired
    @Qualifier("departmentMapper")
    DepartmentMapper departmentMapper;

    @Override
    public EUDataGridResult findAllEmployees(String currentPageNum, String perPageNum) {
        int selectCount = employeeMapper.selectCount();
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        List<Employee> employeeList = employeeMapper.selectByLimitAndOffset();
        for (int i = 0; i < employeeList.size(); i++) {
            Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(employeeList.get(i).getDepartmentId());
            employeeList.get(i).setDepartment(selectByPrimaryKey);
        }
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(employeeList);
        euDataGridResult.setTotal(selectCount);
        return euDataGridResult;
    }

    @Override
    public int insertOneEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public boolean isEmployeeExistById(Employee employee) {
        boolean ret = false;
        Employee selectByPrimaryKey = employeeMapper.selectByPrimaryKey(employee.getEmpId());
        if (selectByPrimaryKey != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean isEmployeeExistByIdCode(Employee employee) {
        boolean ret = false;
        Employee selectByPrimaryKey = employeeMapper.selectByIdCode(employee.getIdCode());
        if (selectByPrimaryKey != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean deleteEmployeesByIds(String[] ids) {
        boolean ret = false;
        int i = 0;
        for (; i < ids.length; i++) {
            int deleteByPrimaryKey = employeeMapper.deleteByPrimaryKey(ids[i]);
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
    public boolean isOtherEmployeeExistByIdCode(Employee employee) {
        boolean ret = false;
        Employee selectOtherByIdCode = employeeMapper.selectOtherByIdCode(employee);
        if (selectOtherByIdCode != null) {
            ret = true;
        }
        return ret;
    }

    @Override
    public int updateOneEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }

    @Override
    public EUDataGridResult findEmployeeById(String currentPageNum, String perPageNum, String employeeId) {
        int selectCount = employeeMapper.selectCountById(employeeId);
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        List<Employee> employeeList = employeeMapper.selectByLimitAndOffsetAndId(employeeId);
        for (int i = 0; i < employeeList.size(); i++) {
            Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(employeeList.get(i).getDepartmentId());
            employeeList.get(i).setDepartment(selectByPrimaryKey);
        }
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(employeeList);
        euDataGridResult.setTotal(selectCount);
        return euDataGridResult;
    }

    @Override
    public EUDataGridResult findEmployeeByName(String currentPageNum, String perPageNum, String employeeName) {
        int selectCount = employeeMapper.selectCountByName(employeeName);
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        List<Employee> employeeList = employeeMapper.selectByLimitAndOffsetAndName(employeeName);
        for (int i = 0; i < employeeList.size(); i++) {
            Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(employeeList.get(i).getDepartmentId());
            employeeList.get(i).setDepartment(selectByPrimaryKey);
        }
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(employeeList);
        euDataGridResult.setTotal(selectCount);
        return euDataGridResult;
    }

    @Override
    public EUDataGridResult findEmployeeByDepartment(String currentPageNum, String perPageNum, String departmentName) {
        List<Department> departmentList = departmentMapper.selectByLimitAndOffsetAndName(departmentName);
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < departmentList.size(); i++) {
            stringArrayList.add(departmentList.get(i).getDepartmentId());
        }
        EmployeeOV employeeOV = new EmployeeOV();
        employeeOV.setDepartmentIds(stringArrayList);
        int selectCount = employeeMapper.selectCountByEmployeeOV(employeeOV);
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));

        List<Employee> employeeList = employeeMapper.selectByLimitAndOffsetAndEmployeeOV(employeeOV);
        for (int i = 0; i < employeeList.size(); i++) {
            Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(employeeList.get(i).getDepartmentId());
            employeeList.get(i).setDepartment(selectByPrimaryKey);
        }
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(employeeList);
        euDataGridResult.setTotal(selectCount);
        return euDataGridResult;
    }
}
