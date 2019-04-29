package com.klee.AdminLogin.servlet;
import com.klee.AdminLogin.pojo.Admin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Filter implements javax.servlet.Filter {
    FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        HttpSession session=request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        String ads=request.getRequestURI();
        if (ads.indexOf("pages")!=-1){
            if (admin==null){
                PrintWriter out=response.getWriter();
                out.println("<script>alert('请先进行登录!');location.href='../index.jsp'</script>");
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
