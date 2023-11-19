package com.yicj.study.hello.shiro;

import com.yicj.study.hello.service.UserService;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yicj
 * @Since 2023/11/18 23:03
 * @see org.apache.shiro.web.filter.mgt.DefaultFilter
 */
@Configuration
public class ShiroConfiguration {

    private final UserService userService  ;

    public ShiroConfiguration(UserService userService) {
        this.userService = userService;
    }

    /** --------------------------------- 配置Shiro  start---------------------------------**/
    @Bean
    public ShiroFilterFactoryBean shiroFilter(){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean() ;
        bean.setSecurityManager(securityManager());
        //
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        bean.setUnauthorizedUrl("/unauthorized");
        //
        Map<String,String> filterChainDefinitionMap =  new LinkedHashMap<>() ;
        filterChainDefinitionMap.put("/index", "authc") ;
        filterChainDefinitionMap.put("/login", "anon") ;
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean ;
    }

    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager() ;
        securityManager.setRealm(authorizingRealm());
        return securityManager ;
    }

    @Bean
    public AuthorizingRealm authorizingRealm(){
        AuthRealm authRealm = new AuthRealm(userService);
        authRealm.setCredentialsMatcher(credentialsMatcher());
        return authRealm ;
    }

    @Bean("credentialsMatcher")
    public CredentialsMatcher credentialsMatcher(){
        return new AuthCredentialsMatcher() ;
    }
    /** --------------------------------- 配置Shiro与Spring的关联--------------------------**/

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor advisor= new AuthorizationAttributeSourceAdvisor() ;
        advisor.setSecurityManager(securityManager());
        return advisor ;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator() ;
        creator.setProxyTargetClass(true);
        return creator ;
    }

}
