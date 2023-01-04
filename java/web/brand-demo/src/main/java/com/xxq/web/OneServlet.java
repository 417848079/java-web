package com.xxq.web;

import com.xxq.pojo.Brand;
import com.xxq.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "oneServlet", value = "/oneServlet")
public class OneServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //接收id
        Brand brand = brandService.selectOne(Integer.parseInt(request.getParameter("id")));
        //存储
        request.setAttribute("brand",brand);
        //转发
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
