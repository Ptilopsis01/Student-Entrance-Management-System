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
    public List<EnterReport> findEnterReportByStuId(Integer id){
        return enterReportMapper.findEnterReportByStuId(id);
    }
}
