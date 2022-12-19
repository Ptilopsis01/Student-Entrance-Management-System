package com.example.demo.service.admin;

import com.example.demo.manager.*;
import com.example.demo.model.entity.EnterReport;
import com.example.demo.model.entity.LeaveReport;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminRequestService")
public class RequestService {
    private final ClassManager classManager;
    private final DepartmentManager departmentManager;
    private final EnterReportManager enterReportManager;
    private final LeaveReportManager leaveReportManager;
    @Autowired
    public RequestService(ClassManager classManager, EnterReportManager enterReportManager, DepartmentManager departmentManager, LeaveReportManager leaveReportManager){
        this.classManager = classManager;
        this.departmentManager = departmentManager;
        this.enterReportManager = enterReportManager;
        this.leaveReportManager = leaveReportManager;
    }
    public Response<List<EnterReport>> getEnterRequestsByClassId(Integer Id){
        if (classManager.getClassById(Id) == null){
            return new Response<>(Response.FAIL, "班级不存在", null);
        }
        else {
            List<EnterReport> result = enterReportManager.findEnterReportByClassId(Id);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<List<EnterReport>> getEnterRequestsByDeptId(Integer id){
        if (departmentManager.getDepartmentById(id) == null){
            return new Response<>(Response.FAIL, "院系不存在", null);
        }
        else {
            List<EnterReport> result = enterReportManager.findEnterReportByDeptId(id);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<List<LeaveReport>> getLeaveRequestsByClassId(Integer Id){
        if (classManager.getClassById(Id) == null){
            return new Response<>(Response.FAIL, "班级不存在", null);
        }
        else {
            List<LeaveReport> result = leaveReportManager.findLeaveReportByClassId(Id);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<List<LeaveReport>> getLeaveRequestsByDeptId(Integer id){
        if (departmentManager.getDepartmentById(id) == null){
            return new Response<>(Response.FAIL, "院系不存在", null);
        }
        else {
            List<LeaveReport> result = leaveReportManager.findLeaveReportByDeptId(id);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
}
