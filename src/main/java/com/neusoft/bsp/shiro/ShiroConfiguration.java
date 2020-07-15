package com.neusoft.bsp.shiro;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
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
        filtetMap.put("/register/**","anon");

        //！！！测试完记得删掉
        filtetMap.put("/menurole/**","anon");
        filtetMap.put("/cdm/**","anon");

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

//    /**
//     * 配置session监听
//     * @return
//     */
//    @Bean("sessionListener")
//    public ShiroSessionListener sessionListener(){
//        ShiroSessionListener sessionListener = new ShiroSessionListener();
//        return sessionListener;
//    }
//
//    /**
//     * 配置会话ID生成器
//     * @return
//     */
//    @Bean
//    public SessionIdGenerator sessionIdGenerator() {
//        return new JavaUuidSessionIdGenerator();
//    }
//
//    /**
//     * SessionDAO的作用是为Session提供CRUD并进行持久化的一个shiro组件
//     * MemorySessionDAO 直接在内存中进行会话维护
//     * EnterpriseCacheSessionDAO  提供了缓存功能的会话维护，默认情况下使用MapCache实现，内部使用ConcurrentHashMap保存缓存的会话。
//     * @return
//     */
//    @Bean
//    public SessionDAO sessionDAO() {
//        EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
//        //使用ehCacheManager
//        //enterpriseCacheSessionDAO.setCacheManager(ehCacheManager());
//        //设置session缓存的名字 默认为 shiro-activeSessionCache
//        enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
//        //sessionId生成器
//        enterpriseCacheSessionDAO.setSessionIdGenerator(sessionIdGenerator());
//        return enterpriseCacheSessionDAO;
//    }
//
//
//    /**
//     * 配置保存sessionId的cookie
//     * 注意：这里的cookie 不是上面的记住我 cookie 记住我需要一个cookie session管理 也需要自己的cookie
//     * @return
//     */
//    @Bean("sessionIdCookie")
//    public SimpleCookie sessionIdCookie(){
//        //这个参数是cookie的名称
//        SimpleCookie simpleCookie = new SimpleCookie("sid");
//        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
//
//        //setcookie()的第七个参数
//        //设为true后，只能通过http访问，javascript无法访问
//        //防止xss读取cookie
//        simpleCookie.setHttpOnly(false);
//        simpleCookie.setPath("/");
//        //maxAge=-1表示浏览器关闭时失效此Cookie
//        simpleCookie.setMaxAge(-1);
//        return simpleCookie;
//    }
//
//    /**
//     * 配置会话管理器，设定会话超时及保存
//     * @return
//     */
//    @Bean("sessionManager")
//    public SessionManager sessionManager() {
//
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
//        //配置监听
//        listeners.add(sessionListener());
//        sessionManager.setSessionListeners(listeners);
//        sessionManager.setSessionIdCookie(sessionIdCookie());
//        sessionManager.setSessionDAO(sessionDAO());
//        //sessionManager.setCacheManager(ehCacheManager());
//
//        return sessionManager;
//
//    }
//    /**
//     * 配置核心安全事务管理器
//     * @return
//     */
////    @Bean(name="securityManager")
////    public SecurityManager securityManager() {
////        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
////        //设置自定义realm.
////        securityManager.setRealm(shiroRealm());
////        //配置记住我
////        securityManager.setRememberMeManager(rememberMeManager());
////
////        //配置 ehcache缓存管理器
////        securityManager.setCacheManager(ehCacheManager());
////
////        //配置自定义session管理，使用ehcache 或redis
////        securityManager.setSessionManager(sessionManager());
////
////        return securityManager;
////    }







}
