package com.example.demo.controller.student;

import com.example.demo.service.student.AuthService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("StudentAuthController")
@RequestMapping("/student/auth")
public class AuthController {
    private final AuthService authService;
    @Autowired
    AuthController(AuthService authService){
        this.authService = authService;
    }
    @GetMapping("/{id}")
    public Response<Integer> getAuth(@PathVariable Integer id){
        return authService.getAuth(id);
    }
}
