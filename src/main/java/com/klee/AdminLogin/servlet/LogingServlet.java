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
import java.io.IOException;
import java.io.PrintWriter;
@Controller
@WebServlet("/login.do")
public class LogingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;utf-8");
        String adminName=request.getParameter("adminname");
        String adminPwd=request.getParameter("adminpwd");
        String MD5AdminPwd= Md5Encrypt.MD5(adminPwd);
        Admin admin=new Admin();
        admin.setAdminName(adminName);
        admin.setAdminPwd(MD5AdminPwd);
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        LoginService loginService = (LoginService) context.getBean("loginService");
        Admin admin1 = loginService.findAdminSerivce(admin);
        PrintWriter out=response.getWriter();
        if (admin1!=null){
            out.println("<script>alert('登录成功!');location.href='home.jsp'</script>");
        }
        else {
            out.println("<script>alert('登录失败!');history.back()</script>");
        }
    }
}
