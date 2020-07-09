package com.neusoft.bsp.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filtetMap = new LinkedHashMap<>();
        filtetMap.put("/","anon");

        filtetMap.put("/login/relogin","anon");
        filtetMap.put("/login/checkUser","anon");
        filtetMap.put("/login/getInfo","anon");
        filtetMap.put("/login/logout","anon");

        filtetMap.put("/login/userlist","perms[user:userlist]");

        filtetMap.put("/swagger-ui.html","anon");
        filtetMap.put("/swagger-resources/**","anon");
        filtetMap.put("/v2/**","anon");
        filtetMap.put("/webjars/**","anon");

        filtetMap.put("/**","authc");

        shiroFilterFactoryBean.setLoginUrl("/login/relogin");

        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtetMap);

        return shiroFilterFactoryBean;
    }
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

}
