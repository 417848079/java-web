package com.xxq.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.xxq.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * <p>
 * 品牌数据的增删改查
 * <p>
 *
 * @className: BrandTest
 * @author: xxq
 * @create: 2022-12-21 11:19
 */
public class BrandTest {

    /**
     *
     * 查询所有
     * */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        // 1. 获取Connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        //定义sql语句
        String sql = "select * from tb_brand";

        // 获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);

        //执行sql
        ResultSet rs = pstmt.executeQuery(sql);

        // 处理结果
        List<Brand> list = new ArrayList<>();
        Brand brand = null;
        while (rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            //封装Brand对象
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);
            list.add(brand);
        }
        System.out.println(list);
        //释放资源
        rs.close();
        pstmt.close();
        connection.close();


    }


    /**
     * 添加
     * */
    @Test
    public void testAdd() throws Exception {
        System.out.println(System.getProperty("user.dir"));

        //接收参数
        String brandName="香飘飘";
        String companyName="香飘飘技术有限公司";
        int ordered = 200;
        String description="卖奶茶的";
        int status=1;

        // 1. 获取Connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        //定义sql语句
        String sql = "INSERT INTO tb_brand(brand_name,company_name,ordered,description,status) VALUES(?,?,?,?,?)";

        // 获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);

        //设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        //执行sql
        int count = pstmt.executeUpdate();
        System.out.println(count>0);
        //释放资源
        pstmt.close();
        connection.close();


    }


    /**
     * 修改
     * */
    @Test
    public void testUpdate() throws Exception {
        System.out.println(System.getProperty("user.dir"));

        //接收参数
        String brandName="香飘飘";
        String companyName="香飘飘技术有限公司";
        int ordered = 1000;
        String description="卖奶茶的,绕地球三圈";
        int status=1;
        int id = 4;

        // 1. 获取Connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        //定义sql语句
        String sql = "update tb_brand set brand_name = ?,company_name = ?,ordered = ?,description = ?,status = ? where id = ?";

        // 获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);

        //设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);
        //执行sql
        int count = pstmt.executeUpdate();
        System.out.println(count>0);
        //释放资源
        pstmt.close();
        connection.close();


    }


    /**
     * 删除
     * */
    @Test
    public void testDeleteById() throws Exception {
        int id = 4;
        // 1. 获取Connection
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        //定义sql语句
        String sql = "delete from tb_brand  where id = ?";

        // 获取pstmt对象
        PreparedStatement pstmt = connection.prepareStatement(sql);

        //设置参数
        pstmt.setInt(1,id);
        //执行sql
        int count = pstmt.executeUpdate();
        System.out.println(count>0);
        //释放资源
        pstmt.close();
        connection.close();
        prop.clone();


    }
}


