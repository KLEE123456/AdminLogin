package com.klee.AdminLogin.service.impl;

import com.github.pagehelper.PageHelper;
import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int insertAdmin(Admin admin) {

        int rows = adminMapper.insertAdmin(admin);
        return rows;

    }

    @Override
    public Admin findAdminByName(String adminName) {
        Admin admin=adminMapper.findAdminByName(adminName);
        return admin;
    }

    @Override
    public Admin xRAdmin(int id) {
        Admin admin = adminMapper.xRAdmin(id);
        return admin;
    }

    @Override
    public int deleteAdmin(String id) {
        int rows = adminMapper.deleteAdmin(id);
        return rows;
    }

    @Override
    public int editAdmin(Admin admin) {
        int rows = adminMapper.editAdmin(admin);
        return rows;
    }

    @Override
    public int registerAdminService(Admin admin) {

        int rows = adminMapper.registerAdmin(admin);
        return rows;

    }

    @Override
    public List<Admin> findAllAdminService(int pageNum) {
        if (pageNum==0){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,5);
        List<Admin> adminList = adminMapper.findAllAdmin();
        return adminList;
    }

    @Override
    public Admin findAdminSerivce(Admin admin) {
        Admin admin1 = adminMapper.findAdmin(admin);
        return admin1;
    }
}
