package com.xxq.web;

import com.xxq.pojo.Brand;
import com.xxq.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAll")
public class SelectAllServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //1.调用BrandService完成查询

        List<Brand> brands = brandService.selectAll();
        //2.存入request域中
        request.setAttribute("brands", brands);
        //3.转发到页面
        request.getRequestDispatcher("/brand.jsp").forward(request,response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
