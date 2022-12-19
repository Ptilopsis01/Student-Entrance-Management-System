package com.example.demo.manager;

import com.example.demo.mapper.LogMapper;
import com.example.demo.model.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("LogManager")
public class LogManager {
    private final LogMapper logMapper;
    @Autowired
    LogManager(LogMapper logMapper){
        this.logMapper = logMapper;
    }
    public void save(Log log){
          logMapper.save(log);
    }
    public List<Log> getLogByStuId(Integer id){
        return logMapper.findLogByStuId(id);
    }
}
