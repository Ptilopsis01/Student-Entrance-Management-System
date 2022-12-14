package com.example.demo.controller.student;

import com.example.demo.model.entity.EnterReport;
import com.example.demo.model.entity.LeaveReport;
import com.example.demo.service.student.RequestService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("RequestController")
@RequestMapping("/student/request")
public class RequestController {
    private final RequestService requestService;
    @Autowired
    RequestController(RequestService requestService){
        this.requestService = requestService;
    }
    @GetMapping("/enter/{id}")
    public Response<List<EnterReport>> getEnterReport(@PathVariable Integer id){
        return requestService.getEnterReport(id);
    }
    @PostMapping("/enter/")
    public Response<EnterReport> addEnterReport(@RequestBody EnterReport enterReport){
        return requestService.addEnterReport(enterReport);
    }
    @GetMapping("/leave/{id}")
    public Response<List<LeaveReport>> getLeaveReport(@PathVariable Integer id){
        return requestService.getLeaveReport(id);
    }
    @PostMapping("/leave/")
    public Response<LeaveReport> addLeaveReport(@RequestBody LeaveReport leaveReport){
        return requestService.addLeaveReport(leaveReport);
    }
}
