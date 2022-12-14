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
    public List<LeaveReport> findLeaveReportByStuId(Integer id){
        return leaveReportMapper.findLeaveReportByStuId(id);
    }
}
