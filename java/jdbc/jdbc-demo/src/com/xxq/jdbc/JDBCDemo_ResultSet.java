package com.xxq.jdbc;

import com.xxq.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * jdbc Api resultSet
 */
public class JDBCDemo_ResultSet {

    /**
     * 执行DQL语句
     */
    @Test
    public void testResult() throws Exception {

        // 1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver"); //可以注释

        //2.获取连接
        String url = "jdbc:mysql:///study?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "select * from account";

        // 4.获取statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //6.处理结果，遍历rs中的所有数据
        //6.1 光标向下移动一行，并且判断当前行是否有数据
//        while (rs.next()) {
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            double money = rs.getDouble(3);
//
//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(money);
//            System.out.println("-------------");
//        }
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("-------------");
        }


        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


    /**
     * 查询account账户表数据，封装为Account对象中，并且存储到ArrayList集合中
     *
     * 1.定义实体类Account
     * 2.查询数据，封装到Account对象中
     * 3.将Account对象存入ArrayList中
     * */
    @Test
    public void testResult2() throws Exception {

        // 1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver"); //可以注释

        //2.获取连接
        String url = "jdbc:mysql:///study?useSSL=false";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义sql
        String sql = "select * from account";

        // 4.获取statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        ResultSet rs = stmt.executeQuery(sql);


        //创建集合
        List<Account> list = new ArrayList<>();

        while (rs.next()) {
            Account account = new Account();

            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            //存入集合
            list.add(account);
        }
        System.out.println(list);

        //释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

}
