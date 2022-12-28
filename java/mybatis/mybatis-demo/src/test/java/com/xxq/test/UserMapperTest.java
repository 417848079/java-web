package com.xxq.test;

import com.xxq.mapper.UserMapper;
import com.xxq.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


/**
 * <p>
 * 测试用例
 * <p>
 *
 * @ClassName: UserMapperTest
 * @Author: xxq
 * @Create: 2022-12-26 15:47
 */
public class UserMapperTest {
    @Test
    public void testSelectById() throws IOException {
        //获取SqlSessionFactory对象
        String resource="mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);


        //2.获取SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();

        //3.获取Mapper接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //4.执行方法
        User user = mapper.selectById(1);

        System.out.println(user);

        //5.释放资源
        sqlSession.close();

    }
}