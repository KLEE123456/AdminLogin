package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.AdminListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/selectAll.do")
public class AdminListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminListService adminListService=(AdminListService)context.getBean("adminListService");
        List<Admin> adminList = adminListService.findAllAdminService();
        request.setAttribute("adminList",adminList);
        request.getRequestDispatcher("pages/home.jsp").forward(request,response);
    }
}
