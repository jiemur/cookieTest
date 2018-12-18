package com.wzn.filter;   /*过滤器*/

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {  /*初始化*/

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {  /*执行*/
        servletRequest.setCharacterEncoding("utf-8");
        /*向后放行*/
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {   /*销毁*/

    }
}
