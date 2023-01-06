package com.xxq.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * <p>
 *
 * <p>
 *
 * @ClassName: FilterDemo
 * @Author: xxq
 * @Create: 2023-01-06 14:16
 */

@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        //放行前，对request数据进行处理
        System.out.println("filter...");

        //放行
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}