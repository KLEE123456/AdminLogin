package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.AdminService;
import com.klee.AdminLogin.utils.Md5Encrypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
    ApplicationContext context=null;
    AdminService adminService=null;
    @Override
    public void init() throws ServletException {
       context=new ClassPathXmlApplicationContext("spring-config.xml");
       adminService=(AdminService)context.getBean("adminService");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName=request.getParameter("adminname");
        String adminPwd=request.getParameter("adminpwd");
        String MD5adminPwd= Md5Encrypt.MD5(adminPwd);
        String adminPhone=request.getParameter("adminphone");
        String adminSex=request.getParameter("adminsex");
        Admin admin=new Admin();
        admin.setAdminName(adminName);
        admin.setAdminPwd(MD5adminPwd);
        admin.setAdminPhone(adminPhone);
        admin.setAdminSex(adminSex);
        int rows = adminService.registerAdminService(admin);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.println("<script>alert('注册成功!');location.href='index.jsp'</script>");
        }
        else {
            out.println("<script>alert('注册失败!');history.back()</script>");
        }
    }
}
