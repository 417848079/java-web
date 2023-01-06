package com.xxq.json;

import com.alibaba.fastjson.JSON;

/**
 * <p>
 *
 * <p>
 *
 * @ClassName: FastJsonDemo
 * @Author: xxq
 * @Create: 2023-01-06 17:22
 */
public class FastJsonDemo {

    public static void main(String[] args) {
        //1.将java对象转为json字符串
        User user = new User();
        user.setId(1);
        user.setUsername("zhs");
        user.setPassword("111");

        String s = JSON.toJSONString(user);
        System.out.println(s);

        //2.将json字符串转为Java对象
        User user1 = JSON.parseObject(s, User.class);
        System.out.println(user1);
    }


}