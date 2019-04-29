package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.EditAdmService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("editAdmService")
public class EditAdmServiceImpl implements EditAdmService {
    @Override
    public int editAdmin(Admin admin) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminMapper adminMapper = context.getBean(AdminMapper.class);
        int rows = adminMapper.editAdmin(admin);
        return rows;
    }
}
