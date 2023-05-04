package com.cy.store.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Title: LoginInterceptor
 * @Author Alvin
 * @Package com.cy.store.interceptor
 * @Date 2023/4/21 16:08
 * @description: 定义拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局Session对象中是否有uid数据，如果有则放行，如果没有重定向到登录界面
     * @param request   请求对象
     * @param response  响应对象
     * @param handler   处理器（url+controller；映射）
     * @return  如果当前返回值为true表示放行当前的请求，如果返回值为false则表示拦截当前的请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // HttpServletRequest对象来获取session对象
        Object obj = request.getSession().getAttribute("uid");
        if (obj == null) {
            //说明用户没有登录过系统，则重定向到login.html页面
            response.sendRedirect("/web/login.html");
            //结束后续调用
            return false;
        }
        //请求放行
        return true;
    }
}
