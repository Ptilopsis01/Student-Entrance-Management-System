package com.example.demo.service.student;

import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.Student;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("StudentAuthService")
public class AuthService {
    private final StudentManager studentManager;
    @Autowired
    public AuthService(StudentManager studentManager){
        this.studentManager = studentManager;
    }
    public Response<Integer> getAuth(Integer studentId) {
        Student student = studentManager.getStudentById(studentId);
        if (student == null) {
            return new Response<>(Response.FAIL, "student不存在", null);
        }
        return new Response<>(Response.SUCCESS, "成功", student.getAuth());
    }
}
