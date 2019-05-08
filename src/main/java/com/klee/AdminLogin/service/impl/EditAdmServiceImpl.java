package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.EditAdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("editAdmService")
public class EditAdmServiceImpl implements EditAdmService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int editAdmin(Admin admin) {
        int rows = adminMapper.editAdmin(admin);
        return rows;
    }
}
