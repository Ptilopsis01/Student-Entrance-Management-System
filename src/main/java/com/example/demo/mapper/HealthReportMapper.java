package com.example.demo.mapper;

import com.example.demo.model.entity.HealthReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthReportMapper extends JpaRepository<HealthReport, Integer> {
    List<HealthReport> findHealthReportByStuId(Integer id);
}

