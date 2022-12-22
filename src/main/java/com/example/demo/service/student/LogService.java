package com.example.demo.service.student;

import com.example.demo.manager.LogManager;
import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.Log;
import com.example.demo.model.entity.Student;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

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
            if (Objects.equals(stu.getStatus(), log.getType())) {
                return new Response<>(Response.FAIL, "学生未出校/进校", null);
            }
            else {
                stu.setStatus(log.getType());
                studentManager.update(stu);
                Timestamp date = new Timestamp(System.currentTimeMillis());
                log.setTime(date);
                logManager.save(log);
                return new Response<>(Response.SUCCESS, "成功", null);
            }
        }
    }
    public Response<List<Log>> getLog(Integer studentId) {
        if (studentManager.getStudentById(studentId) == null) {
            return new Response<>(Response.FAIL, "student不存在", null);
        }
        else {
            List<Log> result = logManager.getLogByStuId(studentId);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
}
