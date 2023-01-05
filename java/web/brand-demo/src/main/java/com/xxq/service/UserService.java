package com.xxq.service;

import com.xxq.mapper.UserMapper;
import com.xxq.pojo.User;
import com.xxq.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * <p>
 *
 * <p>
 *
 * @ClassName: UserService
 * @Author: xxq
 * @Create: 2023-01-05 15:06
 */
public class UserService {
    //1.获取sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * @author: amw
     * @createTime: 2023年01月05 15:10:45
     * @description: 登录
     * @param: name - [String]
     * @param: password - [String]
     * @return: com.xxq.pojo.User
     */
    public User login(String name,String password){
        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.执行方法
        User select = mapper.select(name, password);
        //5.释放资源
        sqlSession.close();
        return select;
    }
}