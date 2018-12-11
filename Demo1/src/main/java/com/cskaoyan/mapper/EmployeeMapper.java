package com.cskaoyan.mapper;

import com.cskaoyan.bean.Employee;
import com.cskaoyan.utils.EmployeeOV;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String empId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    int selectCount();

    List<Employee> select();

    Employee selectByIdCode(String idCode);

    Employee selectOtherByIdCode(Employee employee);

    int selectCountById(String employeeId);

    int selectCountByName(String employeeName);

    List<Employee> selectByNames(String employeeName);

    int selectCountByEmployeeOV(EmployeeOV employeeOV);

    List<Employee> selectByEmployeeOV(EmployeeOV employeeOV);

    List<Employee> selectByDepartmentForOneToMany(String departmentId);
}