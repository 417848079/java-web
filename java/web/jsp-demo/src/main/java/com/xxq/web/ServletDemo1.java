package com.xxq.web;

import com.xxq.pojo.Brand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.准备数据
        List<Brand> brands = new ArrayList<Brand>();
        Brand brand = new Brand();
        brands.add(new Brand(1, "三只松鼠", "三只松鼠食品", 100, "好吃的很", 1));
        brands.add(new Brand(2, "小米", "小米科技", 100, "为发烧", 0));
        brands.add(new Brand(3, "华为", "华为科技", 1000, "科技巨头", 1));

        //2.存储到request域名中
        request.setAttribute("brands",brands);
        request.setAttribute("status",1);
        //3.转发到el-demo.jsp
        //request.getRequestDispatcher("/el-demo.jsp").forward(request,response);
        //request.getRequestDispatcher("/jstl-if.jsp").forward(request,response);
        request.getRequestDispatcher("/jstl-foreach.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
