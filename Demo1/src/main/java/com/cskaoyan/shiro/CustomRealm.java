package com.cskaoyan.shiro;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.bean.vo.UserRoleVO;
import com.cskaoyan.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    SysUserService sysUserService;

    @Override
    public String getName() {
        return "customRealm";
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("认证");
        //token中获得username
        String principal = (String) authenticationToken.getPrincipal();
        System.out.println(principal);
        //从数据库查到对象
        UserRoleVO activeUser = sysUserService.findActiveUserByUsername(principal);
        if(activeUser==null){
            return null;
            //这就可以导致UnknownAccountException!!!
        }
        String passwordFromDB = activeUser.getPassword();
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(activeUser, passwordFromDB, getName());
        return simpleAuthenticationInfo;
    }

    //授权，方法上要有对应注解或者配置文件里写有对应url，拒绝后是返回一个拒绝页面，好像用不到。。。
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("xxx");
        UserRoleVO primaryPrincipal = (UserRoleVO) principalCollection.getPrimaryPrincipal();
        //去数据库查找对应的role和permission，多表查询
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        List<String> permissionsByUsername = sysUserService.findPermissionsByUsername(primaryPrincipal.getUsername());
        simpleAuthorizationInfo.addStringPermissions(permissionsByUsername);
        return simpleAuthorizationInfo;
    }


}
