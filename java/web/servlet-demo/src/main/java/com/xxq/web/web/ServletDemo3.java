package com.xxq.web.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * <p>
 *  Servlet 方法介绍
 * <p>
 *
 * @ClassName: ServletDemo1
 * @Author: xxq
 * @Create: 2022-12-27 10:45
 */
@WebServlet(urlPatterns = "/demo3",loadOnStartup = 1)
public class ServletDemo3 implements Servlet {

    private ServletConfig servletConfig;
    /**
     * @author: amw
     * @createTime: 2022年12月27 11:23:04
     * @description:
     * 初始化方法
     *  1.调用时机：默认情况下，Servlet被第一次访问时，调用
     *      *loadOnStarttup
     *  2.调用次数：1次
     * @param: servletConfig - [ServletConfig]
     * @return: void
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;
        System.out.println("init... 初始化");
    }

    /**
     * @author: amw
     * @createTime: 2022年12月27 11:31:10
     * @description:
     *  提供服务
     *  1.调用时机：每一次Servlet被访问时，调用
     *  2.调用次数：多次
     * @param: servletRequest - [ServletRequest]
     * @param: servletResponse - [ServletResponse]
     * @return: void
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello word");
    }

    /**
     * @author: amw
     * @createTime: 2022年12月27 11:34:17
     * @description:
     *  销毁方法
     *  1.调用时机：内存释放或者服务器关闭,Servlet对象会被销毁，调用
     *  2.调用次数：1次
     * @param:
     * @return: void
     */
    public void destroy() {
        System.out.println("destroy.....  销毁");
    }



    public ServletConfig getServletConfig() {
        return servletConfig;
//        return null;
    }



    public String getServletInfo() {
        return null;
    }


}