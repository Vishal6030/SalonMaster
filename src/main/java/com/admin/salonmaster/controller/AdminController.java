package com.admin.salonmaster.controller;

import com.admin.salonmaster.dto.AdminLoginDTO;
import com.admin.salonmaster.entity.Admin;
import com.admin.salonmaster.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/v1")
public class AdminController {

    private AdminService adminService;

    @PostMapping("/add")
    public ResponseEntity<Object> addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @PostMapping("/login/username")
    public ResponseEntity<Object> loginByUsername(AdminLoginDTO adminLoginDTO){
        return adminService.loginByUsername(adminLoginDTO);
    }
}
