package com.example.demo.service.student;

import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.Student;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("InfoService")
public class InfoService {
    private final StudentManager studentManager;
    @Autowired
    public InfoService(StudentManager studentManager){
        this.studentManager = studentManager;
    }
    public Response<Student> getInfo(Integer Id) {
        Student student = studentManager.getStudentById(Id);
        if (student == null) {
            return new Response<>(Response.FAIL, "学生不存在", null);
        }
        return new Response<>(Response.SUCCESS, "成功", student);
    }
    public Response<Student> editInfo(Student student) {
        studentManager.update(student);
        return new Response<>(Response.SUCCESS, "成功", student);
    }
}
