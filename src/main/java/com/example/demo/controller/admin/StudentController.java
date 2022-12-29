package com.example.demo.controller.admin;

import com.example.demo.model.entity.Student;
import com.example.demo.service.admin.StudentService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AdminStudentController")
@RequestMapping("/admin/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/leave/list/")
    public Response<List<Object>> getLeftStudent(){
        return studentService.getLeftStudent();
    }
    @GetMapping("/leave/no-request/")
    public Response<List<Student>> getLeftStudentNoRequest(){
        return studentService.getLeftStudentNoRequest();
    }
    @GetMapping("/not-leave/in-request/")
    public Response<List<Student>> getNotLeftStudentInRequest(){
        return studentService.getNotLeftStudentInRequest();
    }
    @GetMapping("/class/{id}")
    public Response<List<Student>> getStudentByClassId(@PathVariable Integer id){
        return studentService.getStudentByClassId(id);
    }
    @GetMapping("/dept/{id}")
    public Response<List<Student>> getStudentByDeptId(@PathVariable Integer id){
        return studentService.getStudentByDeptId(id);
    }
}
