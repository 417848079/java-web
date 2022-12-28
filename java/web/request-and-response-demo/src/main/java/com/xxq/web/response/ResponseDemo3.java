package com.xxq.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author: amw
 * @createTime: 2022年12月28 15:57:10
 * @description: 响应字符数据
 * @param: null - [null]
 * @return: null
 */

@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取字符输出流
        PrintWriter writer = response.getWriter();
        //content-type
        //response.setHeader("content-type","text/html");

        writer.write("aaa");
        writer.write("<h1>aaa</h1>");
        writer.write("<h1>你好</h1>");

        //细节：流不需要关闭

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
