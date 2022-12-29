package com.example.demo.manager;

import com.example.demo.mapper.LeaveReportMapper;
import com.example.demo.model.entity.LeaveReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("LeaveReportManager")
public class LeaveReportManager {
    private final LeaveReportMapper leaveReportMapper;
    @Autowired
    public LeaveReportManager(LeaveReportMapper leaveReportMapper){
        this.leaveReportMapper = leaveReportMapper;
    }
    public void save(LeaveReport leaveReport){
        leaveReportMapper.save(leaveReport);
    }
    public LeaveReport findLeaveReportById(Integer id){
        return leaveReportMapper.findLeaveReportById(id);
    }
    public List<LeaveReport> findLeaveReportByStuId(Integer id){
        return leaveReportMapper.findLeaveReportByStuId(id);
    }
    public List<LeaveReport> findLeaveReportByClassId(Integer id){
        return leaveReportMapper.findLeaveReportByClassId(id);
    }
    public List<LeaveReport> findLeaveReportByDeptId(Integer id){
        return leaveReportMapper.findLeaveReportByDeptId(id);
    }
    public List<LeaveReport> findLeaveReportByStatus(Integer status){
        return leaveReportMapper.findLeaveReportByStatus(status);
    }
    public List<LeaveReport> findAllLeaveReport(){
        return leaveReportMapper.findAll();
    }
}
