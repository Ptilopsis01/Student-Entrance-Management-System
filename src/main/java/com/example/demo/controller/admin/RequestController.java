package com.example.demo.controller.admin;

import com.example.demo.model.entity.EnterReport;
import com.example.demo.model.entity.LeaveReport;
import com.example.demo.service.admin.RequestService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("AdminRequestController")
@RequestMapping("/request")
public class RequestController {
    private final RequestService requestService;
    @Autowired
    RequestController(RequestService requestService){
        this.requestService = requestService;
    }
    @GetMapping("/enter/class/{id}")
    public Response<List<EnterReport>> getEnterRequestsByClassId(@PathVariable Integer id){
        return requestService.getEnterRequestsByClassId(id);
    }
    @GetMapping("/enter/dept/{id}")
    public Response<List<EnterReport>> getEnterRequestsByDeptId(@PathVariable Integer id){
        return requestService.getEnterRequestsByDeptId(id);
    }
    @GetMapping("/leave/class/{id}")
    public Response<List<LeaveReport>> getLeaveRequestsByClassId(@PathVariable Integer id){
        return requestService.getLeaveRequestsByClassId(id);
    }
    @GetMapping("/leave/dept/{id}")
    public Response<List<LeaveReport>> getLeaveRequestsByDeptId(@PathVariable Integer id){
        return requestService.getLeaveRequestsByDeptId(id);
    }
    @PostMapping("/enter/approve/")
    public Response<EnterReport> approveEnterRequest(@RequestParam Integer id, Integer status, String reason){
        return requestService.editEnterRequest(id, status, reason);
    }
    @PostMapping("/leave/approve/")
    public Response<LeaveReport> approveLeaveRequest(@RequestParam Integer id, Integer status, String reason){
        return requestService.editLeaveRequest(id, status, reason);
    }
}
