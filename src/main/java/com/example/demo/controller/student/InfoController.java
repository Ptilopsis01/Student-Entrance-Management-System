package com.example.demo.controller.student;

import com.example.demo.model.entity.Student;
import com.example.demo.service.student.InfoService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("StudentInfoController")
@RequestMapping("/student/info")
public class InfoController {
    private final InfoService infoService;
    @Autowired
    InfoController(InfoService infoService){
        this.infoService = infoService;
    }
    @GetMapping("/{id}")
    public Response<Student> getInfo(@PathVariable Integer id) {
        return infoService.getInfo(id);
    }
    @PostMapping("/")
    public Response<Student> editInfo(@RequestBody Student student) {
        return infoService.editInfo(student);
    }
}
