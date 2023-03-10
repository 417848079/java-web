package com.xxq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * @author: amw
 * @createTime: 2023年01月06 14:37:27
 * @description: 登录验证过滤器
 * @param: null - [null]
 * @return: null
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException
            , IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        //判断访问的路径是否与登录注册相关
        String[] urls={"/login.jsp","/assets","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};

        //获取访问资源路径
        String s = req.getRequestURL().toString();
        //循环判断
        for(String u:urls){
            if(s.contains(u)){
                //找到了
                chain.doFilter(request, response);
                return;
            }
        }

        //1.判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        //判断user是否为null
        if(user!=null){
            //登录过了
            //放行
            chain.doFilter(request, response);
        }else{
            //没登录 ，跳转到登录页面
            req.setAttribute("login_msg","尚未登录，请登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }


    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {

    }


}
