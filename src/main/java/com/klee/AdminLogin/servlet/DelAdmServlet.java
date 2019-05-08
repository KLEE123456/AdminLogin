package com.klee.AdminLogin.servlet;

import com.klee.AdminLogin.service.DelAdmService;
import com.klee.AdminLogin.service.LoginService;
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

@WebServlet("/delete.do")
public class DelAdmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminId=request.getParameter("adminid");
        String pageNum=request.getParameter("pageNum");
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        HttpSession session=request.getSession();
        session.setAttribute("pageNum",pageNum);
        DelAdmService delAdmService=(DelAdmService)context.getBean("delAdmService");
        int rows = delAdmService.deleteAdmin(adminId);
        PrintWriter out=response.getWriter();
        if (rows>0){
           out.println("<script>alert('删除成功!');location.href='selectAll.do'</script>");
        }
        else {
            out.println("<script>alert('删除失败!');location.href='selectAll.do'</script>");
        }
    }
}
