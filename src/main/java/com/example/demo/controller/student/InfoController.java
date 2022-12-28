package com.example.demo.controller.student;

import com.example.demo.model.entity.Student;
import com.example.demo.service.student.InfoService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("StudentInfoController")
@RequestMapping("/student/info")
public class InfoController {
    private final InfoService infoService;
    @Autowired
    InfoController(InfoService infoService){
        this.infoService = infoService;
    }
    @GetMapping("/get/{id}")
    public Response<Student> getInfo(@PathVariable Integer id) {
        return infoService.getInfo(id);
    }
}
