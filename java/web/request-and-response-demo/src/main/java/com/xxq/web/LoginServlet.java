package com.xxq.web;

import com.xxq.mapper.UserMapper;
import com.xxq.pojo.User;
import com.xxq.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2.调用mybatis完成查询
        //2.1获取SqlSessionFaction对象
       // String resource = "mybatis-config.xml";
        //InputStream inputStream = Resources.getResourceAsStream(resource);
        //SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);*/
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

        //2.2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.3获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //2.4调用方法
        User select = mapper.select(username, password);

        //2.5 释放资源
        sqlSession.close();

        //3.判断user是否为null
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if(select!=null){
            //登录成功
            writer.write("登录成功");
        }else{
            //登录失败
            writer.write("登录失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        this.doGet(request, response);
    }
}
