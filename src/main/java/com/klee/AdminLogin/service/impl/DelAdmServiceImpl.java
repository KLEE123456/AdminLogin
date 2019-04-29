package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.service.DelAdmService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("delAdmService")
public class DelAdmServiceImpl implements DelAdmService {
    @Override
    public int deleteAdmin(String id) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");
        AdminMapper adminMapper = context.getBean(AdminMapper.class);
        int rows = adminMapper.deleteAdmin(id);
        return rows;
    }
}
