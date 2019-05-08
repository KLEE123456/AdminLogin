package com.klee.AdminLogin.service.impl;

import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.service.DelAdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("delAdmService")
public class DelAdmServiceImpl implements DelAdmService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int deleteAdmin(String id) {
        int rows = adminMapper.deleteAdmin(id);
        return rows;
    }
}
