package com.cskaoyan.controller;

import com.cskaoyan.bean.SysRolePermission;
import com.cskaoyan.service.SysPermissionService;
import com.cskaoyan.utils.JsonChangeRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理权限
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    SysPermissionService sysPermissionService;


    //根据角色查找权限
    @ResponseBody
    @RequestMapping("/get_permission")
    public SysRolePermission findPermissionByRoleId(String roleId){
        return sysPermissionService.findPermissionByRoleId(roleId);
    }

    //更新角色对应的权限，就是更新关系表
    @ResponseBody
    @RequestMapping("/update_by_roleid")
    public JsonChangeRet updateByRoleId(String roleId, String permission){
        JsonChangeRet jsonChangeRet=new JsonChangeRet();
        SysRolePermission sysRolePermission=new SysRolePermission();
        sysRolePermission.setSysRoleId(roleId);
        sysRolePermission.setSysPermissionId(permission);
        if(sysPermissionService.updatePermissionByRoleId(sysRolePermission)){
            jsonChangeRet.setStatus(200);
            jsonChangeRet.setMsg("OK");
        }else{
            jsonChangeRet.setMsg("添加失败");
        }
        return jsonChangeRet;
    }
}
