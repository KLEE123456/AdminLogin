package com.klee.AdminLogin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.klee.AdminLogin.mapper.AdminMapper;
import com.klee.AdminLogin.pojo.Admin;
import com.klee.AdminLogin.service.AdminListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("adminListService")
public class AdminListServiceImpl implements AdminListService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> findAllAdminService(int pageNum) {
        if (pageNum==0){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,5);
        List<Admin> adminList = adminMapper.findAllAdmin();
        return adminList;
    }

}
