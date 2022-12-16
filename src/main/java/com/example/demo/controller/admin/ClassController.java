package com.example.demo.controller.admin;

import com.example.demo.model.entity.Student;
import com.example.demo.model.entity.Class;
import com.example.demo.service.admin.ClassService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("AdminClassController")
@RequestMapping("/class")
public class ClassController {
    private final ClassService classService;
    @Autowired
    ClassController(ClassService classService){
        this.classService = classService;
    }
    @GetMapping("/{id}")
    public Response<Class> getClassById(@PathVariable Integer id){
        return classService.getClassById(id);
    }
    @GetMapping("/admin/{id}")
    public Response<Class> getClassByAdminId(@PathVariable Integer id){
        return classService.getClassByAdminId(id);
    }
    @GetMapping("/dept/{id}")
    public Response<List<Class>> getClassesByDeptId(@PathVariable Integer id){
        return classService.getClassesByDeptId(id);
    }
    @GetMapping("/students/{id}")
    public Response<List<Student>> getStudentsByClassId(@PathVariable Integer id){
        return classService.getStudentsByClassId(id);
    }
}
