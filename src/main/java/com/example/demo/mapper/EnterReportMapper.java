package com.example.demo.mapper;

import com.example.demo.model.entity.EnterReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterReportMapper extends JpaRepository<EnterReport, Integer> {
    List<EnterReport> findEnterReportByStuId(Integer id);
    List<EnterReport> findEnterReportByClassId(Integer id);
    List<EnterReport> findEnterReportByDeptId(Integer id);
    EnterReport findEnterReportById(Integer id);
    List<EnterReport> findEnterReportByStatus(Integer status);
    Integer countByStuId(Integer id);
}
