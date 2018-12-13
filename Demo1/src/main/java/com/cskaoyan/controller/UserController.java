package com.cskaoyan.controller;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.bean.vo.UserRoleVO;
import com.cskaoyan.service.SysUserService;
import com.cskaoyan.utils.JsonChangeRet;
import com.cskaoyan.utils.JsonFindRet;
import com.cskaoyan.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 施巍啸
 * 处理用户相关
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    SysUserService sysUserService;

    //前往user_list.jsp
    @RequestMapping("/find")
    public String findUserListJsp(){
        return "user_list";
    }

    //找到所有用户，包括其角色，用vo
    @ResponseBody
    @RequestMapping("/list")
    public JsonFindRet<UserRoleVO> findUserList(Integer page, Integer rows){
        UserRoleVO userRoleVO=new UserRoleVO();
        JsonFindRet<UserRoleVO> userWithRoleByPage = sysUserService.findUserWithRoleByPage(userRoleVO, page, rows);
        return userWithRoleByPage;
    }

    //多条件查询
    @ResponseBody
    @RequestMapping("/search_user_by_userId")
    public JsonFindRet<UserRoleVO> findUserListByUserId(String searchValue, Integer page, Integer rows){
        UserRoleVO userRoleVO=new UserRoleVO();
        userRoleVO.setId(searchValue);
        JsonFindRet<UserRoleVO> userWithRoleByPage = sysUserService.findUserWithRoleByPage(userRoleVO, page, rows);
        return userWithRoleByPage;
    }

    @ResponseBody
    @RequestMapping("/search_user_by_userName")
    public JsonFindRet<UserRoleVO> findUserListByUsername(String searchValue, Integer page, Integer rows){
        UserRoleVO userRoleVO=new UserRoleVO();
        userRoleVO.setUsername(searchValue);
        JsonFindRet<UserRoleVO> userWithRoleByPage = sysUserService.findUserWithRoleByPage(userRoleVO, page, rows);
        return userWithRoleByPage;
    }

    @ResponseBody
    @RequestMapping("/search_user_by_roleName")
    public JsonFindRet<UserRoleVO> findUserListByRoleName(String searchValue, Integer page, Integer rows){
        UserRoleVO userRoleVO=new UserRoleVO();
        userRoleVO.setRoleName(searchValue);
        JsonFindRet<UserRoleVO> userWithRoleByPage = sysUserService.findUserWithRoleByPage(userRoleVO, page, rows);
        return userWithRoleByPage;
    }

    //判断增删改的权限，返回信息
    //不是去返回一个拒绝后的页面，那么得直接去查，然后返回json
    @ResponseBody
    @RequestMapping("/add_judge")
    public Map userAddJudge(HttpSession session){
        Map<String, String> map=new HashMap<>();
        UserRoleVO activeUser = (UserRoleVO) session.getAttribute("activeUser");
        boolean addJudge = sysUserService.userAddJudge(activeUser);
        if(!addJudge){
            map.put("msg", "您没有权限，请切换用户登录！");
        }
        return map;
    }

    //跳转到add.jsp
    @RequestMapping("/add")
    public String findUserAddJsp(){
        return "user_add";
    }

    //处理添加用户，还要添加对应的角色关系。。。用户-角色表。
    @ResponseBody
    @RequestMapping("/insert")
    public JsonChangeRet addUser(@Valid UserRoleVO userRoleVO, BindingResult bindingResult){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        //判断验证信息
        String errorMsg= ValidateUtil.handleError(bindingResult);
        if(errorMsg!=null&&!errorMsg.trim().isEmpty()){
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        //判断添加用户的id是否重复
        SysUser sysUserById=sysUserService.findUserById(userRoleVO.getId());
        if(sysUserById!=null&&sysUserById.getId()!=null){
            jsonChangeRet.setMsg("ID重复，更换ID");
            return jsonChangeRet;
        }
        //添加用户，同时要添加关系表
        if(sysUserService.addUser(userRoleVO)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("新增用户信息成功");
        }else{
            jsonChangeRet.setMsg("添加失败");
        }
        return jsonChangeRet;
    }


    //判断修改权限
    @ResponseBody
    @RequestMapping("/edit_judge")
    public Map userEditJudge(HttpSession session){
        Map<String, String> map=new HashMap<>();
        UserRoleVO activeUser = (UserRoleVO) session.getAttribute("activeUser");
        boolean editJudge = sysUserService.userEditJudge(activeUser);
        if(!editJudge){
            map.put("msg", "您没有权限，请切换用户登录！");
        }
        return map;
    }

    //跳转到编辑的jsp
    @RequestMapping("/edit")
    public String findUserEditJsp(){
        return "user_edit";
    }

    //处理对应id的user的update，也要更新关系表
    @ResponseBody
    @RequestMapping("/update_all")
    public JsonChangeRet updateUser(@Valid UserRoleVO userRoleVO, BindingResult bindingResult){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        //判断验证信息
        String errorMsg= ValidateUtil.handleError(bindingResult);
        if(errorMsg!=null&&!errorMsg.trim().isEmpty()){
            jsonChangeRet.setMsg(errorMsg);
            return jsonChangeRet;
        }
        //更新用户，同时要更新关系表
        if(sysUserService.updateUser(userRoleVO)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("修改用户信息成功");
        }else{
            jsonChangeRet.setMsg("添加失败");
        }
        return jsonChangeRet;
    }

    //删除权限判断
    @ResponseBody
    @RequestMapping("/delete_judge")
    public Map userDeleteJudge(HttpSession session){
        Map<String, String> map=new HashMap<>();
        UserRoleVO activeUser = (UserRoleVO) session.getAttribute("activeUser");
        boolean deleteJudge = sysUserService.userDeleteJudge(activeUser);
        if(!deleteJudge){
            map.put("msg", "您没有权限，请切换用户登录！");
        }
        return map;
    }

    //批量删除
    @ResponseBody
    @RequestMapping("/delete_batch")
    public JsonChangeRet deleteUserById(String ids){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        boolean isDeleteAll=sysUserService.deleteUser(ids);
        if(isDeleteAll){
            jsonChangeRet.setMsg("OK");
            jsonChangeRet.setStatus(200);
        }else{
            jsonChangeRet.setMsg("删除失败");
        }
        return jsonChangeRet;
    }

    //更新用户的角色及权限
    //跳转到角色的编辑jsp上
    @RequestMapping("/role")
    public String findUserRoleEditJsp(){
        return "user_role_edit";
    }

}
