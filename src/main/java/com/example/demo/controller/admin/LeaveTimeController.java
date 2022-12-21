package com.example.demo.controller.admin;

import com.example.demo.service.admin.LeaveTimeService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("LeaveTimeController")
@RequestMapping("/admin/leave-time")
public class LeaveTimeController {
    private final LeaveTimeService leaveTimeService;
    @Autowired
    LeaveTimeController(LeaveTimeService leaveTimeService){
        this.leaveTimeService = leaveTimeService;
    }
    @GetMapping("/student/{id}")
    public Response<Long> getLeaveTime(@PathVariable Integer id){
        return leaveTimeService.getLeaveTime(id);
    }//返回离校总时长（分钟）
    @GetMapping("/all")
    public Response<List<Object>> getAllLeaveTime(){
        return leaveTimeService.getAllLeaveTime();
    }//返回所有学生离校时长（分钟）
    @GetMapping("/class/{classId}")
    public Response<List<Object>> getClassLeaveTime(@PathVariable Integer classId){
        return leaveTimeService.getLeaveTimeByClass(classId);
    }//返回班级学生离校时长（分钟）
    @GetMapping("/dept/{deptId}")
    public Response<List<Object>> getDeptLeaveTime(@PathVariable Integer deptId){
        return leaveTimeService.getLeaveTimeByDept(deptId);
    }//返回院系学生离校时长（分钟）
}
