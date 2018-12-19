package aaa.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class shiroFilter {

    /**
     * 配置Shiro拦截器
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/adminController/login");
        shiroFilterFactoryBean.setSuccessUrl("/adminController/SuccessIndex");
        Map<String,String> map=new LinkedHashMap<String,String>();
        map.put("/assets/**","anon");
        map.put("/logout","anon");
        map.put("/favicon.ico","anon");
        map.put("/js/jquery-1.11.0.min.js","anon");
        map.put("/adminController/loginIndex","anon");
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 注入自定义realm对象
     * @return
     */
    @Bean
    public customRealm customRealm(){
        return new customRealm();
    }

    /**
     * 注入securityManger对象
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(customRealm());
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
