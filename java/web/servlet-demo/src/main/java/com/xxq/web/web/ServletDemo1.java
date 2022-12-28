package com.xxq.web.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * <p>
 *
 * <p>
 *
 * @ClassName: ServletDemo1
 * @Author: xxq
 * @Create: 2022-12-27 10:45
 */
@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello word");
    }


    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }



    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}