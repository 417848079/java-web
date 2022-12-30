package com.xxq.web;

import com.xxq.mapper.UserMapper;
import com.xxq.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        //1.接收数据
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");

        //封装用户对象
        User user = new User();
        user.setUsername(userName);
        user.setPassword(passWord);

        //2.调用mapper根据用户名查询用户
        //2.1获取SqlSessionFaction对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);

        //2.2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //2.4调用方法
        User selectByUserName = mapper.selectByUserName(userName);

        //3.判断用户对象是否为NUll
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(selectByUserName==null){
            //用户名不存在
            mapper.add(user);
            //提交事务
            sqlSession.commit();
            // 释放资源
            sqlSession.close();
            writer.write("注册成功");
        }else{
            writer.write("用户名已存在");
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
