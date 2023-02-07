package com.xxq.web.servlet;

import com.alibaba.fastjson.JSON;
import com.xxq.pojo.Brand;
import com.xxq.service.BrandService;
import com.xxq.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl()  ;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询
        List<Brand> brands = brandService.selectAll();

        //2.将集合转换为JSON数据  序列化
        //String s = JSON.toJSONString(brands, SerializerFeature.WriteNullNumberAsZero);
        String s = JSON.toJSONString(brands);

        //3.响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(s);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
