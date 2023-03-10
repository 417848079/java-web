package com.xxq.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * Druid数据库连接池演示
 * <p>
 *
 * @className: DruidDemo
 * @author: xxq
 * @create: 2022-12-21 10:16
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        //1. 导入jar包

        //2.定义配置文件

        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}