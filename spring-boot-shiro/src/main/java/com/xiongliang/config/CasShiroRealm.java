package com.xiongliang.config;

import com.xiongliang.entity.Menu;
import com.xiongliang.entity.Role;
import com.xiongliang.entity.User;
import com.xiongliang.service.IUserService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public class CasShiroRealm extends CasRealm {

    //用户方法
    @Autowired
    IUserService userService;

    private static final Logger logger = LoggerFactory.getLogger(CasShiroRealm.class);


    @PostConstruct
    public void initProperty(){
//      setDefaultRoles("ROLE_USER");
        setCasServerUrlPrefix(ShiroCasConfiguration.casServerUrlPrefix);
        // 客户端回调地址
        setCasService(ShiroCasConfiguration.shiroServerUrlPrefix + ShiroCasConfiguration.casFilterUrlPattern);
    }

    /**
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
        String loginName = (String)super.getAvailablePrincipal(principalCollection);
        //到数据库查是否有此对象
        User user=userService.findByLoginName(loginName);// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        if(user!=null){
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

            for (Role role:user.getRoleList()){
                authorizationInfo.addRole(role.getEnname());
                for (Menu p:role.getPermissions()){
                    authorizationInfo.addStringPermission(p.getPermission());
                }
            }
            return authorizationInfo;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }


}
