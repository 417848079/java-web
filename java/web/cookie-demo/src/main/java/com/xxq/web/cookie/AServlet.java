package com.xxq.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "AServlet", value = "/AServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //发送cookie

        //1.创建cookie
        //Cookie cookie = new Cookie("username","zs");
        String value = "张三";
        value = URLEncoder.encode(value,"UTF-8");
        Cookie cookie = new Cookie("username",value);

        //设置存活时间 1周 7天
        cookie.setMaxAge(60*60*24*7);

        //2.发送cookie
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
