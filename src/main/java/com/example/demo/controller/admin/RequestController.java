package com.example.demo.controller.admin;

import com.example.demo.model.entity.EnterReport;
import com.example.demo.model.entity.LeaveReport;
import com.example.demo.service.admin.RequestService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("AdminRequestController")
@RequestMapping("/admin/request")
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
    @GetMapping("/enter/un/{days}")
    public Response<List<EnterReport>> getUnapprovedEnterRequests(@PathVariable Integer days){
        return requestService.getUnapprovedEnterRequests(days);
    }
    @GetMapping("/leave/un/{days}")
    public Response<List<LeaveReport>> getUnapprovedLeaveRequests(@PathVariable Integer days){
        return requestService.getUnapprovedLeaveRequests(days);
    }
    @GetMapping("/enter/count/all/")
    public Response<List<Object>> countAllEnterRequest(){
        return requestService.countAllEnterRequests();
    }
    @GetMapping("/enter/count/class/{id}")
    public Response<List<Object>> countEnterRequestByClassId(@PathVariable Integer id){
        return requestService.countEnterRequestsByClassId(id);
    }
    @GetMapping("/enter/count/dept/{id}")
    public Response<List<Object>> countEnterRequestByDeptId(@PathVariable Integer id){
        return requestService.countEnterRequestsByDeptId(id);
    }
}
