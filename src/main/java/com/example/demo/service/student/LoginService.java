package com.example.demo.service.student;

import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.Student;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginService")
public class LoginService {
    private final StudentManager studentManager;
    @Autowired
    public LoginService(StudentManager studentManager){
        this.studentManager = studentManager;
    }
    public Response<Student> login(Integer Id) {
        Student student = studentManager.getStudentById(Id);
        if (student == null) {
            return new Response<>(Response.FAIL, "学生不存在", null);
        }
        else {
            return new Response<>(Response.SUCCESS, "成功", student);
        }
    }
}
