package com.example.demo.service.student;

import com.example.demo.manager.HealthReportManager;
import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.HealthReport;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
            if (days > 0 && days < result.size()) {
                result = result.subList(result.size() - days, result.size());
            }
            else if (days >= result.size()) {
                result = result.subList(0, result.size());
            }
            else {
                return new Response<>(Response.FAIL, "days参数错误", null);
            }
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<HealthReport> addHealthReport(HealthReport healthReport) {
        if (studentManager.getStudentById(healthReport.getStuId()) == null) {
            return new Response<>(Response.FAIL, "学生不存在", null);
        }
        else {
            Timestamp date = new Timestamp(System.currentTimeMillis());
            List<HealthReport> previousReport = healthReportManager.findHealthReportByStuId(healthReport.getStuId());
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            if (fmt.format(previousReport.get(previousReport.size() - 1).getSubDate()).equals(fmt.format(date))) {
                return new Response<>(Response.FAIL, "今日已填报", null);
            }
            else {
                healthReport.setSubDate(date);
                healthReportManager.save(healthReport);
                return new Response<>(Response.SUCCESS, "成功", null);
            }
        }
    }
}
