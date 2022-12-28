package com.xxq.web.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 *
 * <p>
 *
 * @ClassName: MyHttpServlet
 * @Author: xxq
 * @Create: 2022-12-27 15:13
 */
public class MyHttpServlet  implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 根据请求方式的不同，进行分别处理
        HttpServletRequest request = (HttpServletRequest) req;
        //1.获取请求方式
        String method = request.getMethod();
        //2.判断
        if("GET".equals(method)){
            //get方式的处理逻辑
            doGet(req,res);
        }else if("POST".equals(method)){
            //post方式的处理逻辑
            doPost(req,res);
        }

    }

    protected void doPost(ServletRequest req, ServletResponse res) {
    }

    protected void doGet(ServletRequest req, ServletResponse res) {
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}