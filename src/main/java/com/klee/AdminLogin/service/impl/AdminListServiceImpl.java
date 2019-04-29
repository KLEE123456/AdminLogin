package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.AdminListService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("adminListService")
public class AdminListServiceImpl implements AdminListService {
    @Override
    public List<Admin> findAllAdminService() {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminMapper adminMapper = context.getBean(AdminMapper.class);
        List<Admin> adminList = adminMapper.findAllAdmin();
        return adminList;
    }
}
