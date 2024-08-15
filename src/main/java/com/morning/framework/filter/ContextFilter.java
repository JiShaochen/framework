package com.morning.framework.filter;

import com.morning.framework.common.dto.ThreadLocalUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author MorningJs
 * @date 2024/8/15 8:21
 * @desc
 */
@WebFilter(urlPatterns = "/*")
public class ContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        ThreadLocalUser.setUser(token);
        filterChain.doFilter(servletRequest, servletResponse);
        ThreadLocalUser.clear();
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}