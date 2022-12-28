package com.example.demo.controller.student;

import com.example.demo.model.entity.HealthReport;
import com.example.demo.service.student.HealthReportService;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("HealthReportController")
@RequestMapping("/student/health-report")
public class HealthReportController {
    private final HealthReportService healthReportService;
    @Autowired
    HealthReportController(HealthReportService healthReportService){
        this.healthReportService = healthReportService;
    }
    @PostMapping("/")
    public Response<List<HealthReport>> getHealthReport(Integer stuId, Integer days){
        return healthReportService.getHealthReport(stuId, days);
    }
    @PostMapping("/add/")
    public Response<HealthReport> addHealthReport(@RequestBody HealthReport healthReport){
        return healthReportService.addHealthReport(healthReport);
    }
}
