package com.example.demo.service.student;

import com.example.demo.manager.EnterReportManager;
import com.example.demo.manager.LeaveReportManager;
import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.EnterReport;
import com.example.demo.model.entity.LeaveReport;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RequestService")
public class RequestService {
    private final EnterReportManager enterReportManager;
    private final LeaveReportManager leaveReportManager;
    private final StudentManager studentManager;
    @Autowired
    public RequestService(EnterReportManager enterReportManager, StudentManager studentManager, LeaveReportManager leaveReportManager){
        this.enterReportManager = enterReportManager;
        this.studentManager = studentManager;
        this.leaveReportManager = leaveReportManager;
    }
    public Response<List<EnterReport>> getEnterReport(Integer studentId) {
        if (studentManager.getStudentById(studentId) == null) {
            return new Response<>(Response.FAIL, "student不存在", null);
        }
        else {
            List<EnterReport> result = enterReportManager.findEnterReportByStuId(studentId);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<EnterReport> addEnterReport(EnterReport enterReport) {
        if (studentManager.getStudentById(enterReport.getStuId()) == null) {
            return new Response<>(Response.FAIL, "学生不存在", null);
        }
        else {
            enterReportManager.save(enterReport);
            return new Response<>(Response.SUCCESS, "成功", null);
        }
    }
    public Response<List<LeaveReport>> getLeaveReport(Integer studentId) {
        if (studentManager.getStudentById(studentId) == null) {
            return new Response<>(Response.FAIL, "student不存在", null);
        }
        else {
            List<LeaveReport> result = leaveReportManager.findLeaveReportByStuId(studentId);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<LeaveReport> addLeaveReport(LeaveReport leaveReport) {
        if (studentManager.getStudentById(leaveReport.getStuId()) == null) {
            return new Response<>(Response.FAIL, "学生不存在", null);
        }
        else {
            leaveReportManager.save(leaveReport);
            return new Response<>(Response.SUCCESS, "成功", null);
        }
    }
}
