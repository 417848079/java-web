package com.xxq.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo_Statement {

    /**
     * 执行DML语句
     * */
    @Test
    public void testDML() throws Exception {

        // 1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver"); //可以注释

        //2.获取连接
        String url="jdbc:mysql:///study?useSSL=false";
        String username="root";
        String password="root";
        Connection conn =  DriverManager.getConnection(url,username,password);

        //3.定义sql语句
        String sql = "update account set money = 2000 where id =1";

        // 4.获取执行sql的对象 statement
        Statement stmt = conn.createStatement();

        // 5.执行方法
        int count = stmt.executeUpdate(sql);    //执行DML语句，受影响的行数

        //6.处理结果
        System.out.println(count>0?"修改成功":"修改失败");


        // 7 .释放资源
        stmt.close();
        conn.close();
    }

    @Test
    public void testDDL() throws Exception {

        // 1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver"); //可以注释

        //2.获取连接
        String url="jdbc:mysql:///study?useSSL=false";
        String username="root";
        String password="root";
        Connection conn =  DriverManager.getConnection(url,username,password);

        //3.定义sql语句
        String sql = "drop database db1";

        // 4.获取执行sql的对象 statement
        Statement stmt = conn.createStatement();

        // 5.执行方法
        int count = stmt.executeUpdate(sql);    //执行DDL语句，执行后可能是0

        //6.处理结果
        System.out.println(count>0?"修改成功":"修改失败");


        // 7 .释放资源
        stmt.close();
        conn.close();
    }
}
