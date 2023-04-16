package com.flab.toyboardproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/login/*"})
public class LoginCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginCheckFilter... init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();
        System.out.println("[{}] LoginFilter doFilter Start" + requestURI);

        HttpSession ses= req.getSession();
        Long id = (Long)ses.getAttribute("USER_ID");
        if (id == null) {
            String msg = "로그인 후 이용가능한 서비스입니다.";
            return;
        }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            System.out.println("[{}] LoginFilter doFilter End" + requestURI);
        }
    }

    @Override
    public void destroy() {
        System.out.println("LoginCheckFilter... destroy");
    }
}
