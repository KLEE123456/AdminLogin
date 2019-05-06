package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.AddAdminService;
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

@WebServlet("/add.do")
public class AddAdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName=request.getParameter("adminname");
        String adminPwd=request.getParameter("adminpwd");
        String md5Pwd= Md5Encrypt.MD5(adminPwd);
        String adminPhone=request.getParameter("adminphone");
        String adminSex=request.getParameter("adminsex");
        Admin admin=new Admin();
        admin.setAdminName(adminName);
        admin.setAdminPwd(md5Pwd);
        admin.setAdminPhone(adminPhone);
        admin.setAdminSex(adminSex);
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        AddAdminService addAdmService = (AddAdminService) context.getBean("addAdmService");
        int rows = addAdmService.insertAdmin(admin);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.print("<script>alert('添加成功!');location.href='selectAll.do'</script>");
        }
        else {
            out.print("<script>alert('添加失败!');history.back()</script>");
        }
    }
}
