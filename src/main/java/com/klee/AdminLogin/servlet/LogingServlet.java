package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.LoginService;
import com.klee.AdminLogin.service.impl.LoginServiceImpl;
import com.klee.AdminLogin.utils.Md5Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@Controller
@WebServlet("/login.do")
public class LogingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminPwd=request.getParameter("adminpwd");
        String MD5AdminPwd= Md5Encrypt.MD5(adminPwd);
        String adminName=request.getParameter("adminname");
        PrintWriter out=response.getWriter();
        Admin admin=new Admin();
        admin.setAdminName(adminName);
        admin.setAdminPwd(MD5AdminPwd);
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        LoginService loginService = (LoginService) context.getBean("loginService");
        HttpSession session=request.getSession();
        Admin admin1 = loginService.findAdminSerivce(admin);
        session.setAttribute("admin",admin1);
        if (admin1!=null){
            request.getRequestDispatcher("selectAll.do").forward(request,response);
        }
        else {
            out.println("<script>alert('登录失败,用户名或密码错误!');history.back()</script>");
        }
    }
}
