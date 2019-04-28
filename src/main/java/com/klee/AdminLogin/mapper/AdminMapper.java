package com.klee.AdminLogin.mapper;

import com.klee.AdminLogin.pojo.Admin;

public interface AdminMapper {
    Admin findAdmin(Admin admin);
    int registerAdmin(Admin admin);
}
