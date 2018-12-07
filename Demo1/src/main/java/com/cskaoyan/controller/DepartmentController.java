package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.utils.EUDataGridResult;
import com.cskaoyan.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangGuoming
 * created on 2018/12/6
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    @Qualifier("departmentServiceImpl")
    DepartmentService departmentService;

    //动态页面跳转
    @RequestMapping(value = {"/find"})
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department_list");
        return modelAndView;
    }

    @RequestMapping(value = {"/list"})
    @ResponseBody
    public EUDataGridResult findAllDepartments(String page, String rows) {
        PageHelper<Department> departmentPageHelper = departmentService.findAllDepartments(page, rows);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(departmentPageHelper.getRecords());
        euDataGridResult.setTotal(departmentPageHelper.getTotalRecordsNum());
        return euDataGridResult;
    }

    @RequestMapping(value = {"/add_judge"})
    @ResponseBody
    public EUDataGridResult add_judge(){
        return null;
    }

    //动态页面跳转
    @RequestMapping(value = {"/add"})
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department_add");
        return modelAndView;
    }

    @RequestMapping("insert")
    @ResponseBody
    public EUDataGridResult insertOneDepartment(Department department) {
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        boolean departmentExistById = departmentService.isDepartmentExistById(department);
        boolean departmentExistByName = departmentService.isDepartmentExistByName(department);
        if (departmentExistById || departmentExistByName) {
            euDataGridResult.setStatus(500);
            if (departmentExistById && departmentExistByName) {
                euDataGridResult.setMsg("部门编号、部门名称重复！");
            } else if (departmentExistById) {
                euDataGridResult.setMsg("部门编号重复！");
            }else {
                euDataGridResult.setMsg("部门名称重复！");
            }
            return euDataGridResult;
        }
        int insertOneDepartment = departmentService.insertOneDepartment(department);
        if (insertOneDepartment == 1) {
            euDataGridResult.setStatus(200);
        }
        return euDataGridResult;
    }

    @RequestMapping(value = {"/delete_judge"})
    @ResponseBody
    public EUDataGridResult delete_judge(){
        return null;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public EUDataGridResult deleteDepartmentsByIds(String[] ids) {
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        boolean deleteDepartmentsByIds = departmentService.deleteDepartmentsByIds(ids);
        if (deleteDepartmentsByIds) {
            euDataGridResult.setStatus(200);
        }
        return euDataGridResult;
    }

    @RequestMapping(value = {"/edit_judge"})
    @ResponseBody
    public EUDataGridResult edit_judge(){
        return null;
    }

    //动态页面跳转
    @RequestMapping(value = {"/edit"})
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department_edit");
        return modelAndView;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public EUDataGridResult updateOneDepartment(Department department) {
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        boolean departmentExistByName = departmentService.isOtherDepartmentExistByName(department);
        if (departmentExistByName) {
            euDataGridResult.setStatus(500);
            euDataGridResult.setMsg("部门名称重复！");
            return euDataGridResult;
        }
        int updateOneDepartment = departmentService.updateOneDepartment(department);
        if (updateOneDepartment == 1) {
            euDataGridResult.setStatus(200);
        }
        return euDataGridResult;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public EUDataGridResult updateOneDepartmentNote(Department department) {
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        int updateOneDepartmentNote = departmentService.updateOneDepartmentNote(department);
        if (updateOneDepartmentNote == 1) {
            euDataGridResult.setStatus(200);
        }
        return euDataGridResult;
    }

    @RequestMapping(value = {"/search_department_by_departmentId"})
    @ResponseBody
    public EUDataGridResult findDepartmentById(String page, String rows, String searchValue) {
        PageHelper<Department> departmentPageHelper = departmentService.findDepartmentById(page, rows, searchValue);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(departmentPageHelper.getRecords());
        euDataGridResult.setTotal(departmentPageHelper.getTotalRecordsNum());
        return euDataGridResult;
    }

    @RequestMapping(value = {"/search_department_by_departmentName"})
    @ResponseBody
    public EUDataGridResult findDepartmentByName(String page, String rows, String searchValue) {
        PageHelper<Department> departmentPageHelper = departmentService.findDepartmentByName(page, rows, searchValue);
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        euDataGridResult.setRows(departmentPageHelper.getRecords());
        euDataGridResult.setTotal(departmentPageHelper.getTotalRecordsNum());
        return euDataGridResult;
    }
}
