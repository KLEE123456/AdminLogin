package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int registerAdminService(Admin admin) {

        int rows = adminMapper.registerAdmin(admin);
        return rows;
    }

    @Override
    public Admin findAdminByName(String adminName) {

        Admin admin=adminMapper.findAdminByName(adminName);
        return admin;
    }
}
