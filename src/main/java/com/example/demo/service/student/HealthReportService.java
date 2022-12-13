package com.example.demo.service.student;

import com.example.demo.manager.HealthReportManager;
import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.HealthReport;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("HealthReportService")
public class HealthReportService {
    private final HealthReportManager healthReportManager;
    private final StudentManager studentManager;
    @Autowired
    public HealthReportService(HealthReportManager healthReportManager, StudentManager studentManager){
        this.healthReportManager = healthReportManager;
        this.studentManager = studentManager;
    }
    public Response<List<HealthReport>> getHealthReport(Integer studentId, Integer days) {
        if (studentManager.getStudentById(studentId) == null) {
            return new Response<>(Response.FAIL, "student不存在", null);
        }
        else {
            List<HealthReport> result = healthReportManager.findHealthReportByStuId(studentId);
            if (days != null && days > 0 && days <= result.size()) {
                result.subList(days-1, result.size());
            }
            else {
                return new Response<>(Response.FAIL, "超出范围", null);
            }
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<HealthReport> addHealthReport(HealthReport healthReport) {
        if (studentManager.getStudentById(healthReport.getStuId()) == null) {
            return new Response<>(Response.FAIL, "学生不存在", null);
        }
        else {
            Date d = new Date( );
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            healthReport.setSubDate(ft.format(d));
            healthReportManager.save(healthReport);
            return new Response<>(Response.SUCCESS, "成功", null);
        }
    }
}
