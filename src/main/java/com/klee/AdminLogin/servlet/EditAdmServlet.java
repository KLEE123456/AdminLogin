package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.EditAdmService;
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

@WebServlet("/edit.do")
public class EditAdmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName=request.getParameter("adminname");
        String adminPwd=request.getParameter("adminpwd");
        String md5Pwd = Md5Encrypt.MD5(adminPwd);
        String adminPhone=request.getParameter("adminphone");
        String adminSex=request.getParameter("adminsex");
        String adminId=request.getParameter("adminid");
        Admin admin=new Admin();
        admin.setAdminId(Integer.parseInt(adminId));
        admin.setAdminPwd(md5Pwd);
        admin.setAdminPhone(adminPhone);
        admin.setAdminSex(adminSex);
        admin.setAdminName(adminName);
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        EditAdmService editAdmService=(EditAdmService) context.getBean("editAdmService");
        int rows = editAdmService.editAdmin(admin);
        PrintWriter out=response.getWriter();
        if (rows>0){
            out.println("<script>alert('编辑成功!');location.href='selectAll.do'</script>");
        }
        else{
            out.println("<script>alert('编辑失败!');location.href='selectAll.do'</script>");
        }
    }
}
