package com.garylee.blog.interceptor;

import com.garylee.blog.domain.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by GaryLee on 2018-12-02 17:45.
 * 登陆拦截器
 * 如果不是管理员登陆，则不可以访问requireAuthPages数组中的路径
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath=session.getServletContext().getContextPath();
        //需要登陆才能访问的路径
        String[] requireAuthPages = new String[]{
            "albumEdit",//相册发表
                "edit",//博客发表
                "upload",//上传图片
                "deleteBlog"//删除blog
        };
        String uri = request.getRequestURI();
        //如果在application.properties中有设置server.context-path则需要此步
        uri = StringUtils.remove(uri, contextPath+"/");
        String page = uri;
        //如果请求的uri在requireAuthPages中，则返回false(即跳转到login页面)
        if(begingWith(page,requireAuthPages)){
            //shiro
            Subject subject = SecurityUtils.getSubject();
            //如果没登陆
            if(!subject.isAuthenticated()){
                response.sendRedirect("login");
                return false;
            }
            //登陆了且为管理员
            if(!"root".equals(subject.getPrincipal())) {
                response.sendRedirect("index");
                return true;
            }
        }
        //其他页面默认为true
        return true;
    }
    //判断访问的page是否需要登陆,需要返回true
    private boolean begingWith(String page,String[] requiredAuthPages){
        boolean result = false;
        for(String requiredAuthPage:requiredAuthPages){
            if(StringUtils.startsWith(page,requiredAuthPage)){
                result = true;
                break;
            }
        }
        return result;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
