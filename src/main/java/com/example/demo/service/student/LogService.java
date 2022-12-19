package com.example.demo.service.student;

import com.example.demo.manager.LogManager;
import com.example.demo.manager.StudentManager;
import com.example.demo.model.entity.Log;
import com.example.demo.model.entity.Student;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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
            List<Log> result = logManager.getLogByStuId(studentId);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<Long> getLeaveTime(Integer id) {
        if (studentManager.getStudentById(id) == null) {
            return new Response<>(Response.FAIL, "student不存在", null);
        }
        else {
            List<Log> result = logManager.getLogByStuId(id);
            List<Log> leave = new ArrayList<>();
            List<Log> enter = new ArrayList<>();
            for (Log log : result) {
                if (log.getType() == 1) {
                    leave.add(log);
                } else {
                    enter.add(log);
                }
            }
            long leaveTime = 0;
            if (result.get(result.size()-1).getType() == 1) {
                Date date = new Date(System.currentTimeMillis());;
                leaveTime = date.getTime() - leave.get(leave.size()-1).getTime().getTime();
                for (int i = leave.size()-1; i > 0; i--) {
                    leaveTime += enter.get(i).getTime().getTime() - leave.get(i-1).getTime().getTime();
                }
            }
            else {
                for (int i = enter.size()-1; i > 0; i--) {
                    leaveTime += enter.get(i).getTime().getTime() - leave.get(i-1).getTime().getTime();
                }
            }
            return new Response<>(Response.SUCCESS, "成功", leaveTime/(1000*60));
        }
    }
}
