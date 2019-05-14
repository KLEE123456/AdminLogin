package com.klee.AdminLogin.mapper;

import com.klee.AdminLogin.pojo.Admin;

import java.util.List;

public interface AdminMapper {
    Admin findAdmin(Admin admin);
    List<Admin> findAllAdmin();
    int registerAdmin(Admin admin);
    int deleteAdmin(String id);
    int editAdmin(Admin admin);
    Admin xRAdmin(int id);
    Admin findAdminByName(String adminName);
    int insertAdmin(Admin admin);
    List<Admin> findLikeByAdminName(String adminName);
}
