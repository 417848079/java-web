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


    /**
     * @author: amw
     * @createTime: 2023年01月05 16:58:57
     * @description: 注册用户
     * @param: name - [String]
     * @param: password - [String]
     * @return: java.lang.Boolean
     */
    public Boolean register(User user){
        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //4.注册

        //判断用户名是否存在
        User user1 = mapper.selectByUserName(user.getUsername());
        if(user1==null){
            //用户名不存在,注册
            mapper.add(user);
            sqlSession.commit();

        }
        //5.释放资源
        sqlSession.close();

        return user1==null;
    }
}