package com.klee.AdminLogin.pojo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Admin {
    private  int  adminId;

    private  String adminName;

    private  String adminPhone;

    private  String adminPwd;

    private  String adminSex;


 }
