package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.RegisterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkReg")
public class CheckServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName=request.getParameter("adminName");
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        RegisterService registerService = (RegisterService) context.getBean("registerService");
        Admin adminByName = registerService.findAdminByName(adminName);
        PrintWriter out=response.getWriter();
        if (adminByName==null){
            out.print(1);
        }
        else {
            out.print(0);
        }

    }
}
