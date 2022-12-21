package com.xxq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
* jdbc Connection
* */
public class JDBCDemo_Connection {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver"); //可以注释

        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/study?useSSL=false";
        String username="root";
        String password="root";
        Connection conn =  DriverManager.getConnection(url,username,password);

        //3.定义sql语句
        String sql = "update account set money = 3000 where id =1";
        String sql1 = "update account set money = 3000 where id =2";


        // 4.获取执行sql的对象 statement
        Statement stmt = conn.createStatement();

        // 开启事务

        try {
            conn.setAutoCommit(false);
            // 5.执行方法
            int count = stmt.executeUpdate(sql);    //受影响的行数

            //6.处理结果
            System.out.println(count);

            int i=3/0;  //制造异常

            // 5.执行方法
            int count1 = stmt.executeUpdate(sql1);    //受影响的行数

            //6.处理结果
            System.out.println(count1);

            // 提交事务
            conn.commit();
        } catch (Exception throwables) {
            //回滚事务
            conn.rollback();
            throwables.printStackTrace();
        }



        // 7 .释放资源
        stmt.close();
        conn.close();
    }
}
