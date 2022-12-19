package com.example.demo.manager;

import com.example.demo.mapper.EnterReportMapper;
import com.example.demo.model.entity.EnterReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EnterReportManager")
public class EnterReportManager {
    private final EnterReportMapper enterReportMapper;
    @Autowired
    public EnterReportManager(EnterReportMapper enterReportMapper){
        this.enterReportMapper = enterReportMapper;
    }
    public void save(EnterReport enterReport){
        enterReportMapper.save(enterReport);
    }
    public EnterReport findEnterReportById(Integer id){
        return enterReportMapper.findEnterReportById(id);
    }
    public List<EnterReport> findEnterReportByStuId(Integer id){
        return enterReportMapper.findEnterReportByStuId(id);
    }
    public List<EnterReport> findEnterReportByClassId(Integer id){
        return enterReportMapper.findEnterReportByClassId(id);
    }
    public List<EnterReport> findEnterReportByDeptId(Integer id){
        return enterReportMapper.findEnterReportByDeptId(id);
    }
    public List<EnterReport> findEnterReportByStatus(Integer status){
        return enterReportMapper.findEnterReportByStatus(status);
    }
}
