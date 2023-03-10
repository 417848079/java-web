package com.xxq.web.request;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RequestDemo02", value = "/RequestDemo02")
//@WebServlet("/RequestDemo02")
public class RequestDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        //1.解决乱码：POST.getReader()
//        request.setCharacterEncoding("UTF-8");//设置字符输入流的编码
        //2.获取username
        String username = request.getParameter("username");
        System.out.println("解决乱码前"+username);

        //3.GET方式，获取参数的方式：getQueryString
        // 乱码原因：tomcat进行URL解码，默认的字符集ISO-8859-1
        //3.1 先对乱码数据进行编码：转为字节数组
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        //3.2字节数组解码
        username = new String(bytes,StandardCharsets.UTF_8);

        System.out.println("解决乱码后"+username);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
