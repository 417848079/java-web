package com.xxq.mapper;

import com.xxq.pojo.User;
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
    @Select("select * tb_user where ususername =#{userName} and password=#{passWord}}")
    User Select(@Param("userName") String userName, @Param("passWord") String passWord);
}
