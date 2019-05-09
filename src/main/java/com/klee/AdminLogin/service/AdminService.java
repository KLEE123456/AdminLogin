package com.klee.AdminLogin.service;

import com.klee.AdminLogin.pojo.Admin;

import java.util.List;

public interface AdminService {
    int insertAdmin(Admin admin);
    List<Admin> findAllAdminService(int pageNum);
    int deleteAdmin(String id);
    int editAdmin(Admin admin);
    Admin findAdminSerivce(Admin admin);
    int registerAdminService(Admin admin);
    Admin findAdminByName(String adminName);
    Admin xRAdmin(int id);
}
