package com.klee.AdminLogin.servlet;

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

@WebServlet("/delete.do")
public class DelAdmServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminId=request.getParameter("adminid");
        String pageNum=request.getParameter("pageNum");
        HttpSession session=request.getSession();
        session.setAttribute("pageNum",pageNum);
        AdminService adminService  = (AdminService) request.getSession().getAttribute("adminService");
        int rows = adminService.deleteAdmin(adminId);
        PrintWriter out=response.getWriter();
        if (rows>0){
           out.println("<script>alert('删除成功!');location.href='selectAll.do'</script>");
        }
        else {
            out.println("<script>alert('删除失败!');location.href='selectAll.do'</script>");
        }
    }
}
