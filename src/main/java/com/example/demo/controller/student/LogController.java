package com.example.demo.controller.student;

import com.example.demo.model.entity.Log;
import com.example.demo.service.student.LogService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("LogController")
@RequestMapping("/student/log")
public class LogController {
    private final LogService logService;
    @Autowired
    LogController(LogService logService){
        this.logService = logService;
    }
    @PostMapping("/")
    public Response<Log> addLog(@RequestBody Log log) {
        return logService.addLog(log);
    }
    @GetMapping("/{id}")
    public Response<List<Log>> getLog(@PathVariable Integer id) {
        return logService.getLog(id);
    }
    @GetMapping("/leave-time/{id}")
    public Response<Long> getLeaveTime(@PathVariable Integer id){
        return logService.getLeaveTime(id);
    }//返回离校总时长（分钟）
}
