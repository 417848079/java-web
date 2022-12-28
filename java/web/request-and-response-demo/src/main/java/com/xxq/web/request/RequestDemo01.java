package com.xxq.web.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 *
 * <p>
 *
 * @ClassName: RequestDemo01
 * @Author: xxq
 * @Create: 2022-12-28 10:21
 */
@WebServlet("/req")
public class RequestDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET请求逻辑
//        System.out.println("get...");

        //1.获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key + ":");

            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

        System.out.println("-------------------");

        //2.根据key获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies){
            System.out.println(hobby);
        }
        System.out.println("-------------------");

        //3.获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        System.out.println(username);
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST请求逻辑
        this.doGet(req,resp);
    }
}