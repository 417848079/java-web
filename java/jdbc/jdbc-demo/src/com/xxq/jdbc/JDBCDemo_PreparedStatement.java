package com.xxq.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * Api详解： PreparedStatement
 */
public class JDBCDemo_PreparedStatement {





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

        //定义sql
        String sql = "select * from tb_user where username=? and password=?";


        //获取PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置?的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();


        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }


    @Test
    public void testLogin_Inject2() throws Exception {

        //useServerPrepStmts=true   参数开启预编译功能
        String url = "jdbc:mysql:///study?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户输入 用户名和密码
        String name = "fadfsfa";
        String pwd = "' or '1'='1";

        //定义sql
        String sql = "select * from tb_user where username=? and password=?";


        //获取PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置?的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();


        //判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }



}
