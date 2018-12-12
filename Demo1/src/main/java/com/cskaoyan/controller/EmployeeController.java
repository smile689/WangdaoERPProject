package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.bean.Employee;
import com.cskaoyan.service.EmployeeService;
import com.cskaoyan.utils.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * @author WangGuoming
 * created on 2018/12/8
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;

    /**
     * 查找：查找前页面跳转
     * @return
     */
    @RequestMapping("find")
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee_list");
        return modelAndView;
    }

    /**
     * 查找：查找所有信息
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public EUDataGridResult findAllEmployees(String page, String rows) {
        EUDataGridResult euDataGridResult = employeeService.findAllEmployees(page, rows);
        return euDataGridResult;
    }

    /**
     * 增加：增加前判断权限
     * @return
     */
    @RequestMapping("add_judge")
    @ResponseBody
    public EUDataGridResult add_judge(){
        return null;
    }

    /**
     * 增加：增加前页面跳转
     * @return
     */
    @RequestMapping("add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee_add");
        return modelAndView;
    }

    /**
     * 增加：增加一条信息
     * @param employee
     * @return
     */
    @RequestMapping("insert")
    @ResponseBody
    public EUDataGridResult insertOneEmployee(@Valid Employee employee, BindingResult bindingResult, String departmentId) {
        EUDataGridResult euDataGridResult = new EUDataGridResult(bindingResult);
        if (euDataGridResult.getStatus() == 500) {
            return euDataGridResult;
        }
        boolean employeeExistById = employeeService.isEmployeeExistById(employee);
        boolean employeeExistByIdCode = employeeService.isEmployeeExistByIdCode(employee);
        if (employeeExistById || employeeExistByIdCode) {
            euDataGridResult.setStatus(500);
            if (employeeExistById && employeeExistByIdCode) {
                euDataGridResult.setMsg("errorMessage:员工编号、身份证号重复！");
            } else if (employeeExistById) {
                euDataGridResult.setMsg("errorMessage:员工编号重复！");
            }else {
                euDataGridResult.setMsg("errorMessage:身份证号重复！");
            }
            return euDataGridResult;
        }
        Department department = new Department();
        department.setDepartmentId(departmentId);
        employee.setDepartment(department);
        int insertOneEmployee = employeeService.insertOneEmployee(employee);
        if (insertOneEmployee == 1) {
            euDataGridResult.setStatus(200);
        }
        return euDataGridResult;
    }

    /**
     * 删除：删除前判断权限
     * @return
     */
    @RequestMapping("delete_judge")
    @ResponseBody
    public EUDataGridResult delete_judge(){
        return null;
    }

    /**
     * 删除：删除多条信息
     * @param ids
     * @return
     */
    @RequestMapping("delete_batch")
    @ResponseBody
    public EUDataGridResult deleteEmployeesByIds(String[] ids) {
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        boolean deleteEmployeesByIds = employeeService.deleteEmployeesByIds(ids);
        if (deleteEmployeesByIds) {
            euDataGridResult.setStatus(200);
        } else {
            euDataGridResult.setStatus(500);
        }
        return euDataGridResult;
    }

    /**
     * 更新：更新前判断权限
     * @return
     */
    @RequestMapping("edit_judge")
    @ResponseBody
    public EUDataGridResult edit_judge(){
        return null;
    }

    /**
     * 更新：更新前页面跳转
     * @return
     */
    @RequestMapping("edit")
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee_edit");
        return modelAndView;
    }

    /**
     * 更新：更新一条信息
     * @param employee
     * @return
     */
    @RequestMapping("update_all")
    @ResponseBody
    public EUDataGridResult updateOneEmployee(@Valid Employee employee, BindingResult bindingResult, String departmentId) {
        EUDataGridResult euDataGridResult = new EUDataGridResult(bindingResult);
        if (euDataGridResult.getStatus() == 500) {
            return euDataGridResult;
        }
        boolean employeeExistByIdCode = employeeService.isOtherEmployeeExistByIdCode(employee);
        if (employeeExistByIdCode) {
            euDataGridResult.setStatus(500);
            euDataGridResult.setMsg("errorMessage:身份证号重复！");
            return euDataGridResult;
        }
        Department department = new Department();
        department.setDepartmentId(departmentId);
        employee.setDepartment(department);
        int updateOneEmployee = employeeService.updateOneEmployee(employee);
        if (updateOneEmployee == 1) {
            euDataGridResult.setStatus(200);
        }
        return euDataGridResult;
    }

    /**
     * 查找：根据 id 精确搜索
     * @param page
     * @param rows
     * @param searchValue
     * @return
     */
    @RequestMapping("search_employee_by_employeeId")
    @ResponseBody
    public EUDataGridResult findOneEmployeeById(String page, String rows, String searchValue) {
        EUDataGridResult euDataGridResult = employeeService.findOneEmployeeById(page, rows, searchValue);
        return euDataGridResult;
    }

    /**
     * 查找：根据 name 模糊搜索
     * @param page
     * @param rows
     * @param searchValue
     * @return
     */
    @RequestMapping("search_employee_by_employeeName")
    @ResponseBody
    public EUDataGridResult findEmployeesByNames(String page, String rows, String searchValue) {
        EUDataGridResult euDataGridResult = employeeService.findEmployeesByNames(page, rows, searchValue);
        return euDataGridResult;
    }

    /**
     * 查找：根据 department 模糊搜索
     * @param page
     * @param rows
     * @param searchValue
     * @return
     */
    @RequestMapping("search_employee_by_departmentName")
    @ResponseBody
    public EUDataGridResult findEmployeesByDepartments(String page, String rows, String searchValue) {
        EUDataGridResult euDataGridResult = employeeService.findEmployeesByDepartments(page, rows, searchValue);
        return euDataGridResult;
    }

    /**
     * 查找：查找所有信息，返回 list 类型的 json
     * @return
     */
    @RequestMapping("get_data")
    @ResponseBody
    public List findAllEmployees() {
        EUDataGridResult euDataGridResult = employeeService.findAllEmployees("1", String.valueOf(Integer.MAX_VALUE));
        return euDataGridResult.getRows();
    }
    
    /**
     * 查找：查找一条信息，使用 restful 风格的 url
     * @param empId
     * @return
     */
    @RequestMapping("get/{empId}")
    @ResponseBody
    public Employee findOneEmployeeById(@PathVariable("empId") String empId) {
        EUDataGridResult euDataGridResult = employeeService.findOneEmployeeById("1", String.valueOf(Integer.MAX_VALUE), empId);
        return (Employee) euDataGridResult.getRows().get(0);
    }
}
