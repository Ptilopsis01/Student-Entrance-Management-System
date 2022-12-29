package com.example.demo.mapper;

import com.example.demo.model.entity.LeaveReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveReportMapper extends JpaRepository<LeaveReport, Integer> {
    List<LeaveReport> findLeaveReportByStuId(Integer id);
    List<LeaveReport> findLeaveReportByClassId(Integer id);
    List<LeaveReport> findLeaveReportByDeptId(Integer id);
    LeaveReport findLeaveReportById(Integer id);
    List<LeaveReport> findLeaveReportByStatus(Integer status);
    List<LeaveReport> findAll();
}
