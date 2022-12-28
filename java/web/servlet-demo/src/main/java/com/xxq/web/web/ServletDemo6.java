package com.xxq.web.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

/**
 * <p>
 *
 * <p>
 *
 * @ClassName: ServletDemo5
 * @Author: xxq
 * @Create: 2022-12-27 15:00
 */
@WebServlet("/demo6")
public class ServletDemo6 extends MyHttpServlet {
    @Override
    protected void doGet(ServletRequest req, ServletResponse res) {
        System.out.println("get...");
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse res) {
        System.out.println("post...");
    }
}