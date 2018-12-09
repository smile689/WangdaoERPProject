package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.utils.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    /**
     * 查找：查找前页面跳转
     * @return
     */
    @RequestMapping(value = {"/find"})
    public ModelAndView find(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department_list");
        return modelAndView;
    }

    /**
     * 查找：查找所有信息
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = {"/list"})
    @ResponseBody
    public EUDataGridResult findAllDepartments(String page, String rows) {
        EUDataGridResult euDataGridResult = departmentService.findAllDepartments(page, rows);
        return euDataGridResult;
    }

    /**
     * 增加：增加前判断权限
     * @return
     */
    @RequestMapping(value = {"/add_judge"})
    @ResponseBody
    public EUDataGridResult add_judge(){
        return null;
    }

    /**
     * 增加：增加前页面跳转
     * @return
     */
    @RequestMapping(value = {"/add"})
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department_add");
        return modelAndView;
    }

    /**
     * 增加：增加一条信息
     * @param department
     * @return
     */
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

    /**
     * 删除：删除前判断权限
     * @return
     */
    @RequestMapping(value = {"/delete_judge"})
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
    public EUDataGridResult deleteDepartmentsByIds(String[] ids) {
        EUDataGridResult euDataGridResult = new EUDataGridResult();
        boolean deleteDepartmentsByIds = departmentService.deleteDepartmentsByIds(ids);
        if (deleteDepartmentsByIds) {
            euDataGridResult.setStatus(200);
        }
        return euDataGridResult;
    }

    /**
     * 更新：更新前判断权限
     * @return
     */
    @RequestMapping(value = {"/edit_judge"})
    @ResponseBody
    public EUDataGridResult edit_judge(){
        return null;
    }

    /**
     * 更新：更新前页面跳转
     * @return
     */
    @RequestMapping(value = {"/edit"})
    public ModelAndView edit(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("department_edit");
        return modelAndView;
    }

    /**
     * 更新：更新一条信息
     * @param department
     * @return
     */
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

    /**
     * 更新：更新一条信息的部分内容
     * @param department
     * @return
     */
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

    /**
     * 查找：根据 id 精确搜索
     * @param page
     * @param rows
     * @param searchValue
     * @return
     */
    @RequestMapping(value = {"/search_department_by_departmentId"})
    @ResponseBody
    public EUDataGridResult findDepartmentById(String page, String rows, String searchValue) {
        EUDataGridResult euDataGridResult = departmentService.findDepartmentById(page, rows, searchValue);
        return euDataGridResult;
    }

    /**
     * 查找：根据 name 模糊搜索
     * @param page
     * @param rows
     * @param searchValue
     * @return
     */
    @RequestMapping(value = {"/search_department_by_departmentName"})
    @ResponseBody
    public EUDataGridResult findDepartmentByName(String page, String rows, String searchValue) {
        EUDataGridResult euDataGridResult = departmentService.findDepartmentByName(page, rows, searchValue);
        return euDataGridResult;
    }

    /**
     * 查找：查找所有信息，返回格式变形的 json
     * @return
     */
    @RequestMapping("get_data")
    @ResponseBody
    public List findAllDepartments() {
        EUDataGridResult euDataGridResult = departmentService.findAllDepartments("1", String.valueOf(Integer.MAX_VALUE));
        return euDataGridResult.getRows();
    }

    /**
     * 查找：查找一条信息，利用 restful 风格的 url
     * @param departmentId
     * @return
     */
    @RequestMapping("get/{departmentId}")
    @ResponseBody
    public Department findOneDepartmentById(@PathVariable("departmentId") String departmentId) {
        EUDataGridResult euDataGridResult = departmentService.findDepartmentById("1", String.valueOf(Integer.MAX_VALUE), departmentId);
        return (Department) euDataGridResult.getRows().get(0);
    }
}
