package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.AddAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("addAdmService")
public class AddAdmServiceImpl implements AddAdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int insertAdmin(Admin admin) {

        int rows = adminMapper.insertAdmin(admin);

        return rows;
    }
}
