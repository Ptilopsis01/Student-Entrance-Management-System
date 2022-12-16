package com.example.demo.controller.student;

import com.example.demo.model.entity.Student;
import com.example.demo.service.student.LoginService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("StudentLoginController")
@RequestMapping("/student/login")
public class LoginController {
    private final LoginService loginService;
    @Autowired
    LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    @PostMapping("/")
    public Response<Student> login(Integer id){
        return loginService.login(id);
    }
}
