package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.XRAdminSerrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("xRAdminSerrvice")
public class XRAdminSerrviceImpl implements XRAdminSerrvice {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin xRAdmin(int id) {
        Admin admin = adminMapper.xRAdmin(id);
        return admin;
    }
}
