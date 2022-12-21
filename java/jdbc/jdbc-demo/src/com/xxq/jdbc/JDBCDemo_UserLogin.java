package com.xxq.jdbc;

import com.xxq.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 用户登录
 */
public class JDBCDemo_UserLogin {

    /**
     * 执行DQL语句
     */
    @Test
    public void testLogin() throws Exception {

        String url = "jdbc:mysql:///study?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name = "张三";
        String pwd = "qwer";

        String sql = "select * from tb_user where username='"+name+"' and password='"+pwd+"'";

        //获取statement对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


    /*
    * 演示sql注入
    * */
    @Test
    public void testLogin_Inject() throws Exception {

        String url = "jdbc:mysql:///study?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name = "fadfsfa";
        String pwd = "' or '1'='1";

        String sql = "select * from tb_user where username='"+name+"' and password='"+pwd+"'";

        System.out.println(sql);
        //获取statement对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


}
