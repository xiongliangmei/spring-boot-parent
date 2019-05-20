package com.xiongliang.config;

import com.xiongliang.entity.Menu;
import com.xiongliang.entity.Role;
import com.xiongliang.entity.User;
import com.xiongliang.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    //用户方法
    @Autowired
    IUserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        for (Role role:user.getRoleList()){
            authorizationInfo.addRole(role.getEnname());
            for (Menu p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
        //获取用户输入的账号
       String username = (String) token.getPrincipal();
       System.out.println(token.getCredentials());

       User user = userService.findByLoginName(username);
       if (user == null){
           return null;
       }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
               /* ByteSource.Util.bytes(user.getUsername()),*/
                getName()
        );


        return authenticationInfo;
    }


}
