package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Override
    public Admin findAdminSerivce(Admin admin) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminMapper adminMapper = context.getBean(AdminMapper.class);
        Admin admin1 = adminMapper.findAdmin(admin);
        return admin1;
    }
}
