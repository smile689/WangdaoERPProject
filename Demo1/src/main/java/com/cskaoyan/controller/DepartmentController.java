package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.service.DepartmentService;
import com.cskaoyan.utils.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    @RequestMapping("find")
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
    @RequestMapping("list")
    @ResponseBody
    public EUDataGridResult findAllDepartments(String page, String rows) {
        EUDataGridResult euDataGridResult = departmentService.findAllDepartments(page, rows);
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
    public EUDataGridResult insertOneDepartment(@Valid Department department, BindingResult bindingResult) {
        EUDataGridResult euDataGridResult = EUDataGridResult.bindingResult(bindingResult);
        if (euDataGridResult.getStatus() == 500) {
            return euDataGridResult;
        }
        boolean departmentExistById = departmentService.isDepartmentExistById(department);
        boolean departmentExistByName = departmentService.isDepartmentExistByName(department);
        if (departmentExistById || departmentExistByName) {
            euDataGridResult.setStatus(500);
            if (departmentExistById && departmentExistByName) {
                euDataGridResult.setMsg("errorMessage: 部门编号、部门名称重复！");
            } else if (departmentExistById) {
                euDataGridResult.setMsg("errorMessage: 部门编号重复！");
            }else {
                euDataGridResult.setMsg("errorMessage: 部门名称重复！");
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
    public EUDataGridResult updateOneDepartment(@Valid Department department, BindingResult bindingResult) {
        EUDataGridResult euDataGridResult = EUDataGridResult.bindingResult(bindingResult);
        if (euDataGridResult.getStatus() == 500) {
            return euDataGridResult;
        }
        boolean departmentExistByName = departmentService.isOtherDepartmentExistByName(department);
        if (departmentExistByName) {
            euDataGridResult.setStatus(500);
            euDataGridResult.setMsg("errorMessage: 部门名称重复！");
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
    public EUDataGridResult updateOneDepartmentNote(@Valid Department department, BindingResult bindingResult) {
        EUDataGridResult euDataGridResult = EUDataGridResult.bindingResult(bindingResult);
        if (euDataGridResult.getStatus() == 500) {
            return euDataGridResult;
        }
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
    @RequestMapping("search_department_by_departmentId")
    @ResponseBody
    public EUDataGridResult findOneDepartmentById(String page, String rows, String searchValue) {
        EUDataGridResult euDataGridResult = departmentService.findOneDepartmentById(page, rows, searchValue);
        return euDataGridResult;
    }

    /**
     * 查找：根据 name 模糊搜索
     * @param page
     * @param rows
     * @param searchValue
     * @return
     */
    @RequestMapping("search_department_by_departmentName")
    @ResponseBody
    public EUDataGridResult findDepartmentsByNames(String page, String rows, String searchValue) {
        EUDataGridResult euDataGridResult = departmentService.findDepartmentsByNames(page, rows, searchValue);
        return euDataGridResult;
    }

    /**
     * 查找：查找所有信息，返回 List 类型的 json
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
        EUDataGridResult euDataGridResult = departmentService.findOneDepartmentById("1", String.valueOf(Integer.MAX_VALUE), departmentId);
        return (Department) euDataGridResult.getRows().get(0);
    }
}
