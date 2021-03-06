package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/xr.do")
public class XRServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminId=request.getParameter("adminid");
        String pageNum=request.getParameter("pageNum");
        HttpSession session=request.getSession();
        session.setAttribute("pageNum",pageNum);
        AdminService adminService  = (AdminService) request.getSession().getAttribute("adminService");
        Admin admin = adminService.xRAdmin(Integer.parseInt(adminId));
        request.setAttribute("admin",admin);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }
}
