package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.XRAdminSerrvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("xRAdminSerrvice")
public class XRAdminSerrviceImpl implements XRAdminSerrvice {
    @Override
    public Admin xRAdmin(int id) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminMapper adminMapper = context.getBean(AdminMapper.class);
        Admin admin = adminMapper.xRAdmin(id);
        return admin;
    }
}
