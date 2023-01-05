package com.xxq.mapper;

import com.xxq.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * @author: amw
     * @createTime: 2022年12月28 17:36:44
     * @description: 根据用户名和密码查询用户对象
     * @param: userName - [String]
     * @param: passWord - [String]
     * @return: com.xxq.pojo.User
     */
    @Select("select * from tb_user where username =#{userName} and password=#{passWord}")
    User select(@Param("userName") String userName, @Param("passWord") String passWord);
 
    /**
     * @author: amw
     * @createTime: 2022年12月29 11:04:12
     * @description:根据用户名查询用户对象
     * @param: userName - [String]
     * @return: com.xxq.pojo.User
     */
    @Select("select * from tb_user where username=#{userName}")
    User selectByUserName(String userName);


    /**
     * @author: amw
     * @createTime: 2022年12月30 10:55:38
     * @description:添加用户
     * @param: user - [User]
     * @return: void
     */
    @Insert("insert into tb_user values(null,#{username},#{password})")
    void add(User user);
}
