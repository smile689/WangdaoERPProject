package com.cskaoyan.service.impl;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.mapper.DepartmentMapper;
import com.cskaoyan.mapper.EmployeeMapper;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.utils.EUDataGridResult;
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
        List<Employee> employeeList = employeeMapper.select();
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(employeeList);
        euDataGridResult.setTotal(selectCount);
        euDataGridResult.setStatus(200);
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
        if (employee.getIdCode() == null || employee.getIdCode().equals("")) {
            return false;
        }
        Employee selectByPrimaryKey = employeeMapper.selectByIdCode(employee.getIdCode());
        if (selectByPrimaryKey != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployeesByIds(String[] ids) {
        boolean ret = false;
        int deleteByPrimaryKeys = employeeMapper.deleteByPrimaryKeys(ids);
        if (deleteByPrimaryKeys == ids.length) {
            ret = true;
        }
        return ret;
    }

    @Override
    public boolean isOtherEmployeeExistByIdCode(Employee employee) {
        if (employee.getIdCode() == null || employee.getIdCode().equals("")) {
            return false;
        }
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
    public EUDataGridResult findOneEmployeeById(String currentPageNum, String perPageNum, String employeeId) {
        int selectCount = employeeMapper.selectCountById(employeeId);
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        Employee employee = employeeMapper.selectByPrimaryKey(employeeId);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(employeeList);
        euDataGridResult.setTotal(selectCount);
        euDataGridResult.setStatus(200);
        return euDataGridResult;
    }

    @Override
    public EUDataGridResult findEmployeesByNames(String currentPageNum, String perPageNum, String employeeName) {
        int selectCount = employeeMapper.selectCountByName(employeeName);
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        List<Employee> employeeList = employeeMapper.selectByNames(employeeName);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(employeeList);
        euDataGridResult.setTotal(selectCount);
        euDataGridResult.setStatus(200);
        return euDataGridResult;
    }

    @Override
    public EUDataGridResult findEmployeesByDepartments(String currentPageNum, String perPageNum, String departmentName) {
        List<Department> departmentList = departmentMapper.selectByNames(departmentName);
        List<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < departmentList.size(); i++) {
            stringArrayList.add(departmentList.get(i).getDepartmentId());
        }
        int selectCount = employeeMapper.selectCountByDepartments(stringArrayList);
        com.github.pagehelper.PageHelper.startPage(Integer.parseInt(currentPageNum), Integer.parseInt(perPageNum));
        List<Employee> employeeList = employeeMapper.selectByDepartments(stringArrayList);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(employeeList);
        euDataGridResult.setTotal(selectCount);
        euDataGridResult.setStatus(200);
        return euDataGridResult;
    }
}
