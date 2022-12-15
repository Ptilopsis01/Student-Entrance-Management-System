package com.example.demo.service.student;

import com.example.demo.manager.LogManager;
import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.Log;
import com.example.demo.model.entity.Student;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service("LogService")
public class LogService {
    private final LogManager logManager;
    private final StudentManager studentManager;
    @Autowired
    public LogService(LogManager logManager, StudentManager studentManager){
        this.logManager = logManager;
        this.studentManager = studentManager;
    }
    public Response<Log> addLog(Log log) {
        if (studentManager.getStudentById(log.getStuId()) == null) {
            return new Response<>(Response.FAIL, "student不存在", null);
        }
        else {
            Student stu = studentManager.getStudentById(log.getStuId());
            stu.setStatus(log.getType());
            studentManager.update(stu);
            Date date = new Date(System.currentTimeMillis());
            log.setTime(date);
            logManager.save(log);
            return new Response<>(Response.SUCCESS, "成功", null);
        }
    }
    public Response<List<Log>> getLog(Integer studentId) {
        if (studentManager.getStudentById(studentId) == null) {
            return new Response<>(Response.FAIL, "student不存在", null);
        }
        else {
            List<Log> result = logManager.getLogById(studentId);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
}
