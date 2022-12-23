package com.xxq;

import com.xxq.mapper.UserMapper;
import com.xxq.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * mybatis代理开发
 * <p>
 *
 * @className: MybatisDemo
 * @author: xxq
 * @create: 2022-12-22 15:42
 */
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis核心配置文件 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql
       //3.1获取UserMapper接口的代理对象
        UserMapper usersMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = usersMapper.selectAll();
        System.out.println(userList);

        //4.释放资源
        sqlSession.close();

    }
}