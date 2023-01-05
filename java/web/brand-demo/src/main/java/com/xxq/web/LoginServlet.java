package com.xxq.web;

import com.xxq.pojo.User;
import com.xxq.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //1.获取用户名和密码
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        //获取复选框数据 是否记住密码
        String remember = request.getParameter("remember");


        //调用service查询
        User login = userService.login(userName, password);
        if(login!=null){
            //登录成功 跳转查询所有

            //判断用户是否勾选记住密码
            if("1".equals(remember)){
                //勾选了，发送cookie

                //1.创建cookie对象
                Cookie c_username = new Cookie("username",userName);
                Cookie c_password = new Cookie("password",password);
                //2.设置cookie的存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                //2.发送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            //将登录成功的user对象，存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("login",login);
            response.sendRedirect(request.getContextPath()+"/selectAll");
        }else{
            //登录失败

            //存储错误信息到request中
            request.setAttribute("login_msg","用户名或密码错误");
            //跳转到login.jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
