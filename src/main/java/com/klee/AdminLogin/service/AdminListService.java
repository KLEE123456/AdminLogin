package com.klee.AdminLogin.service;

import com.github.pagehelper.PageInfo;
import com.klee.AdminLogin.pojo.Admin;

import java.util.List;

public interface AdminListService {
    List<Admin> findAllAdminService(int pageNum);
}
