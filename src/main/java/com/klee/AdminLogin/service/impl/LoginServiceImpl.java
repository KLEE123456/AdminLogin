package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin findAdminSerivce(Admin admin) {
        Admin admin1 = adminMapper.findAdmin(admin);
        return admin1;
    }
}
