package com.xxq.web;

import com.xxq.pojo.User;
import com.xxq.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //1.获取用户名和密码
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        //获取用户输入的验证码
        String checkCode = request.getParameter("code");
        //获取程序生成的验证码
        HttpSession session = request.getSession();

        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        //判断用户输入的验证码是否正确 比对
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            //不允许注册
            //注册失败
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }




        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        //2.调用service注册
        Boolean register = userService.register(user);
        //3.判断注册是否成功
        if(register){
            //注册成功 跳转到登录页
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else{
            //注册失败
            request.setAttribute("register_msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
