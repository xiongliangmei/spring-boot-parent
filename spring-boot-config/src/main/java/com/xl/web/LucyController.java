package com.xl.web;

import com.xl.config.ConfigBean;
import com.xl.config.User;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class LucyController {
    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/lucy")
    public String miya(){
        return configBean.getGreeting()+">>>>>"+configBean.getName()+">>>>"+configBean.getUuid()+">>>>"+configBean.getMax();
    }
    @Autowired
    User user;

    @RequestMapping(value = "/user")
    public String user(){
        return user.getName()+user.getAge();
    }
}
