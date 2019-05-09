package com.klee.AdminLogin.servlet;

import com.github.pagehelper.PageInfo;
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
import java.util.List;

@WebServlet("/selectAll.do")
public class AdminListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        HttpSession session=request.getSession();
        String editOrdelPageNum= (String)session.getAttribute("pageNum");
        String pageNums=request.getParameter("pageNum");
        int pageNum;
        if (pageNums==null){
            if (editOrdelPageNum==null){
                pageNum=1;
            }
            else {
                pageNum=Integer.parseInt(editOrdelPageNum);
            }
        }
        else {
            pageNum=Integer.parseInt(pageNums);
        }
        AdminService adminService  = (AdminService) request.getSession().getAttribute("adminService");
        List<Admin> adminList = adminService.findAllAdminService(pageNum);
        request.setAttribute("adminList",adminList);
        PageInfo pageInfo=new PageInfo(adminList);
        request.setAttribute("page",pageInfo);
        request.getRequestDispatcher("pages/home.jsp").forward(request,response);

    }
}
