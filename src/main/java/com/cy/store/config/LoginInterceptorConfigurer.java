package com.cy.store.config;

import com.cy.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: LoginInterceptorConfigurer
 * @Author Alvin
 * @Package com.cy.store.config
 * @Date 2023/4/21 16:39
 * @description: 拦截器注册
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    /*
    * addResourceHandler：访问映射路径
    * addResourceLocations：资源绝对路径
    * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/local/**").addResourceLocations("file:D:/IDEA project/java_project/store/upload/");
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
        //配置白名单：存放在一个List集合
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/products/**");
        //完成拦截器注册
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")  //拦截全部url
                .excludePathPatterns(patterns);

    }
}
