package com.example.demo.controller.admin;

import com.example.demo.model.entity.Class;
import com.example.demo.service.admin.ClassService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("ClassController")
@RequestMapping("/admin/class")
public class ClassController {
    private final ClassService classService;
    @Autowired
    ClassController(ClassService classService){
        this.classService = classService;
    }
    @GetMapping("/list/{deptId}")
    public Response<List<Class>> getClassesByDeptId(@PathVariable Integer deptId){
        return classService.getClassesByDeptId(deptId);
    }
}
