package com.xxq.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ResponseDemo1", value = "/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        System.out.println("resp1....");
        //重定向
        /*//1.设置响应状态码 302
        response.setStatus(302);
        //2.设置响应头 Location
        response.setHeader("Location","/request-and-response-demo/ResponseDemo2");*/

        //简化方式完成重定向
//        response.sendRedirect("/ResponseDemo2");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/ResponseDemo2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
