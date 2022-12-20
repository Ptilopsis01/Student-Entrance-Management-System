package com.example.demo.service.admin;

import com.example.demo.manager.*;
import com.example.demo.model.entity.EnterReport;
import com.example.demo.model.entity.LeaveReport;
import com.example.demo.model.entity.Student;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminRequestService")
public class RequestService {
    private final ClassManager classManager;
    private final StudentManager studentManager;
    private final DepartmentManager departmentManager;
    private final EnterReportManager enterReportManager;
    private final LeaveReportManager leaveReportManager;
    @Autowired
    public RequestService(ClassManager classManager, StudentManager studentManager, EnterReportManager enterReportManager, DepartmentManager departmentManager, LeaveReportManager leaveReportManager){
        this.classManager = classManager;
        this.studentManager = studentManager;
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
    public Response<EnterReport> editEnterRequest(Integer id, Integer status, String reason){
        EnterReport enterReport = enterReportManager.findEnterReportById(id);
        if (enterReport == null){
            return new Response<>(Response.FAIL, "申请不存在", null);
        }
        else {
            if (status == 0 && reason == null){
                return new Response<>(Response.FAIL, "请填写拒绝理由", null);
            }
            else if (status == 1){
                int stuId = enterReport.getStuId();
                Student student = studentManager.getStudentById(stuId);
                student.setAuth(1);
                studentManager.update(student);
                enterReport.setStatus(status);
                enterReport.setReason(reason);
                enterReportManager.save(enterReport);
                return new Response<>(Response.SUCCESS, "成功", enterReport);
            }
            else {
                enterReport.setStatus(status);
                enterReport.setReason(reason);
                enterReportManager.save(enterReport);
                return new Response<>(Response.SUCCESS, "成功", enterReport);
            }
        }
    }
    public Response<LeaveReport> editLeaveRequest(Integer id, Integer status, String reason){
        LeaveReport leaveReport = leaveReportManager.findLeaveReportById(id);
        if (leaveReport == null){
            return new Response<>(Response.FAIL, "申请不存在", null);
        }
        else {
            if (status == 0 && reason == null){
                return new Response<>(Response.FAIL, "请填写拒绝理由", null);
            }
            else if (status == 1){
                int stuId = leaveReport.getStuId();
                Student student = studentManager.getStudentById(stuId);
                student.setAuth(0);
                studentManager.update(student);
                leaveReport.setStatus(status);
                leaveReport.setReason(reason);
                leaveReportManager.save(leaveReport);
                return new Response<>(Response.SUCCESS, "成功", leaveReport);
            }
            else {
                leaveReport.setStatus(status);
                leaveReport.setReason(reason);
                leaveReportManager.save(leaveReport);
                return new Response<>(Response.SUCCESS, "成功", leaveReport);
            }
        }
    }
    public Response<List<EnterReport>> getUnapprovedEnterRequests(){
        List<EnterReport> enterReport = enterReportManager.findEnterReportByStatus(2);
        if (enterReport == null){
            return new Response<>(Response.FAIL, "没有未审批的申请", null);
        }
        else {
            return new Response<>(Response.SUCCESS, "成功", enterReport);
        }
    }
    public Response<List<LeaveReport>> getUnapprovedLeaveRequests(){
        List<LeaveReport> leaveReport = leaveReportManager.findLeaveReportByStatus(2);
        if (leaveReport == null){
            return new Response<>(Response.FAIL, "没有未审批的申请", null);
        }
        else {
            return new Response<>(Response.SUCCESS, "成功", leaveReport);
        }
    }
    public Response<List<Object>> countAllEnterRequests(){
        List<Object> result = enterReportManager.countAllEnterReport();
        if (result == null){
            return new Response<>(Response.FAIL, "没有申请", null);
        }
        else {
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<List<Object>> countEnterRequestsByClassId(Integer id){
        List<Object> result = enterReportManager.countEnterReportByClassId(id);
        if (result == null){
            return new Response<>(Response.FAIL, "没有申请", null);
        }
        else {
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<List<Object>> countEnterRequestsByDeptId(Integer id){
        List<Object> result = enterReportManager.countEnterReportByDeptId(id);
        if (result == null){
            return new Response<>(Response.FAIL, "没有申请", null);
        }
        else {
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
}
