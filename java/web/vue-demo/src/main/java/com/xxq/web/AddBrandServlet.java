package com.xxq.web;

import com.alibaba.fastjson.JSON;
import com.xxq.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/addServlet")
public class AddBrandServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 接收数据 request.getParameter 不能接收json数据
        //String brandName = request.getParameter("brandName");
        request.setCharacterEncoding("utf-8");
        //获取请求体数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();

        //2.将json字符串转为java对象
        Brand brand = JSON.parseObject(s, Brand.class);
        System.out.println(brand);

        //3.调用service添加
        brandService.add(brand);

        //4.响应成功标识
        response.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
