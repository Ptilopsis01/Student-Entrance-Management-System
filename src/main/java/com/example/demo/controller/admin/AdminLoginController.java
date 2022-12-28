package com.example.demo.controller.admin;

import com.example.demo.service.admin.AdminLoginService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("AdminLoginController")
@RequestMapping("/admin/login")
public class AdminLoginController {
    private final AdminLoginService adminLoginService;
    @Autowired
    AdminLoginController(AdminLoginService adminLoginService){
        this.adminLoginService = adminLoginService;
    }
    @PostMapping("/{id}")
    public Response<Object> login(@PathVariable Integer id){
        return adminLoginService.login(id);
    }
}
