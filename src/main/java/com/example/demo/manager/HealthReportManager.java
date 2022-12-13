package com.example.demo.manager;

import com.example.demo.mapper.HealthReportMapper;
import com.example.demo.model.entity.HealthReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("HealthReportManager")
public class HealthReportManager {
    private final HealthReportMapper healthReportMapper;
    @Autowired
    public HealthReportManager(HealthReportMapper healthReportMapper){
        this.healthReportMapper = healthReportMapper;
    }
    public void save(HealthReport healthReport){
        healthReportMapper.save(healthReport);
    }
    public List<HealthReport> findHealthReportByStuId(Integer id){
        return healthReportMapper.findHealthReportByStuId(id);
    }
}
