package com.xxq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
* jdbc 快速入门
* */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver"); //可以注释

        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/study?useSSL=false";
        String username="root";
        String password="root";
        Connection conn =  DriverManager.getConnection(url,username,password);

        //3.定义sql语句
        String sql = "update account set money = 2000 where id =1";

        // 4.获取执行sql的对象 statement
        Statement stmt = conn.createStatement();

        // 5.执行方法
        int count = stmt.executeUpdate(sql);    //受影响的行数

        //6.处理结果
        System.out.println(count);

        // 7 .释放资源
        stmt.close();
        conn.close();
    }
}
