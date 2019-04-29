package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.XRAdminSerrvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/xr.do")
public class XRServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminId=request.getParameter("adminid");
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        XRAdminSerrvice xRAdminSerrvice = (XRAdminSerrvice)context.getBean("xRAdminSerrvice");
        Admin admin = xRAdminSerrvice.xRAdmin(Integer.parseInt(adminId));
        request.setAttribute("admin",admin);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }
}
