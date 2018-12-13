package com.cskaoyan.controller;


import com.cskaoyan.bean.SysRole;
import com.cskaoyan.bean.vo.UserRoleVO;
import com.cskaoyan.service.SysRoleService;
import com.cskaoyan.utils.JsonChangeRet;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理角色管理
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    SysRoleService sysRoleService;


    //找到所有的role集合
    @ResponseBody
    @RequestMapping("/get_data")
    public List<SysRole> findAllRoles(){
        return sysRoleService.findAllRoles();
    }

    //根据id找到对应的role
    @ResponseBody
    @RequestMapping("/get/{roleId}")
    public SysRole findRoleById(@PathVariable String roleId){
        return sysRoleService.findRoleById(roleId);
    }

    //可以增加权限
    @RequestMapping("/find")
    public String findRoleListJsp(){
        return "role_list";
    }

    //找到所有角色
    @ResponseBody
    @RequestMapping("/list")
    public JsonFindRet<SysRole> findRoleList(Integer page, Integer rows){
        SysRole sysRole=new SysRole();
        JsonFindRet<SysRole> rolesByPage=sysRoleService.findRolesByPage(sysRole, page, rows);
        return rolesByPage;
    }

    //多条件查询
    @ResponseBody
    @RequestMapping("/search_role_by_roleId")
    public JsonFindRet<SysRole> findRoleListByRoleId(String searchValue, Integer page, Integer rows){
        SysRole sysRole=new SysRole();
        sysRole.setRoleId(searchValue);
        JsonFindRet<SysRole> rolesByPage = sysRoleService.findRolesByPage(sysRole, page, rows);
        return rolesByPage;
    }

    @ResponseBody
    @RequestMapping("/search_role_by_roleName")
    public JsonFindRet<SysRole> findUserListByUsername(String searchValue, Integer page, Integer rows){
        SysRole sysRole=new SysRole();
        sysRole.setRoleName(searchValue);
        JsonFindRet<SysRole> rolesByPage = sysRoleService.findRolesByPage(sysRole, page, rows);
        return rolesByPage;
    }

    //判断增加权限
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map roleAddJudge(HttpSession session){
        Map<String, String> map=new HashMap<>();
        List<String> sysPermissionList = (List<String>) session.getAttribute("sysPermissionList");
        boolean addJudge = sysRoleService.roleAddJudge(sysPermissionList);
        if(!addJudge){
            map.put("msg", "您没有权限，请切换用户登录！");
        }
        return map;
    }

    //前往添加页面
    @RequestMapping("/add")
    public String findRoleAddJsp(){
        return "role_add";
    }

    //处理角色添加，注意还要添加角色-权限关系表,permission是一个字符串
    @ResponseBody
    @RequestMapping("/insert")
    public JsonChangeRet addRole(@Valid SysRole sysRole, BindingResult bindingResult, String permission){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        //先判断信息合法
        String errorMsg = ValidateUtil.handleError(bindingResult);
        if(errorMsg!=null&&!errorMsg.trim().isEmpty()){
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        //判断角色id重复
        SysRole sysRoleById=sysRoleService.findRoleById(sysRole.getRoleId());
        if(sysRoleById!=null&&sysRoleById.getRoleId()!=null){
            jsonChangeRet.setMsg("ID重复，更换ID");
            return jsonChangeRet;
        }

        //处理添加
        if(sysRoleService.addRole(sysRole, permission)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("新增角色信息成功");
        }else{
            jsonChangeRet.setMsg("添加失败");
        }
        return jsonChangeRet;
    }

    //判断编辑权限
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map roleEditJudge(HttpSession session){
        Map<String, String> map=new HashMap<>();
        List<String> sysPermissionList = (List<String>) session.getAttribute("sysPermissionList");
        boolean editJudge = sysRoleService.roleEditJudge(sysPermissionList);
        if(!editJudge){
            map.put("msg", "您没有权限，请切换用户登录！");
        }
        return map;
    }

    //跳转到编辑页面
    @RequestMapping("/edit")
    public String findRoleEditJsp(){
        return "role_edit";
    }

    //处理编辑
    //更新角色，同时要更新关系表
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateRole(@Valid SysRole sysRole, BindingResult bindingResult, String permission){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        //判断验证信息
        String errorMsg= ValidateUtil.handleError(bindingResult);
        if(errorMsg!=null&&!errorMsg.trim().isEmpty()){
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        //更新角色，同时要更新关系表
        if(sysRoleService.updateRole(sysRole, permission)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("修改角色信息成功");
        }else{
            jsonChangeRet.setMsg("添加失败");
        }
        return jsonChangeRet;
    }

    //删除权限判断
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map roleDeleteJudge(HttpSession session){
        Map<String, String> map=new HashMap<>();
        List<String> sysPermissionList = (List<String>) session.getAttribute("sysPermissionList");
        boolean deleteJudge = sysRoleService.roleDeleteJudge(sysPermissionList);
        if(!deleteJudge){
            map.put("msg", "您没有权限，请切换用户登录！");
        }
        return map;
    }

    //批量删除，注意要删除相应的权限关系表
    @ResponseBody
    @RequestMapping("/delete_batch")
    public JsonChangeRet deleteRole(String ids){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        boolean isDeleteAll=sysRoleService.deleteRole(ids);
        if(isDeleteAll){
            jsonChangeRet.setMsg("OK");
            jsonChangeRet.setStatus(200);
        }else{
            jsonChangeRet.setMsg("删除失败");
        }
        return jsonChangeRet;
    }

    //跳转到权限窗口
    @RequestMapping("/permission")
    public String findPermissionJsp(){
        return "role_permission";
    }

}
