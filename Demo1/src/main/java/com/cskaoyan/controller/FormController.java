package com.cskaoyan.controller;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.bean.vo.UserRoleVO;
import com.cskaoyan.service.SysUserService;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    SysUserService sysUserService;

    //动态页面跳转
    @RequestMapping(value = "/{formName}")
    public String toLogin(@PathVariable String formName, HttpSession session){
        System.out.println(formName);
        //如果登陆成功，添加登陆用户信息，同时添加拥有的权限
        //在这里添加合理吗？
        if("home".equals(formName)){
            SimplePrincipalCollection attribute = (SimplePrincipalCollection) session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
            if(attribute!=null){
                UserRoleVO primaryPrincipal = (UserRoleVO) attribute.getPrimaryPrincipal();
                System.out.println("user="+primaryPrincipal);
                session.setAttribute("activeUser", primaryPrincipal);
                List<String> permissionsByUsername = sysUserService.findPermissionsByUsername(primaryPrincipal.getUsername());
                System.out.println(permissionsByUsername);
                session.setAttribute("sysPermissionList", permissionsByUsername);
            }
        }
        return formName;
    }

}
