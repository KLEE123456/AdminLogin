package com.klee.AdminLogin.servlet;

import com.alibaba.fastjson.JSON;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/checkReg")
public class CheckServlet extends HttpServlet {
    ApplicationContext context=null;
    AdminService adminService=null;
    @Override
    public void init() throws ServletException {
        context=new ClassPathXmlApplicationContext("spring-config.xml");
        adminService=(AdminService) context.getBean("adminService");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName=request.getParameter("adminName");
        Admin adminByName = adminService.findAdminByName(adminName);
        PrintWriter out=response.getWriter();
        if (adminByName==null){
            out.print(1);
        }
        else {
            out.print(0);
        }
    }
}
