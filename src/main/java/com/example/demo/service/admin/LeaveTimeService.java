package com.example.demo.service.admin;

import com.example.demo.manager.ClassManager;
import com.example.demo.manager.DepartmentManager;
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

@Service("LeaveTimeService")
public class LeaveTimeService {
    private final LogManager logManager;
    private final StudentManager studentManager;
    private final ClassManager classManager;
    private final DepartmentManager departmentManager;
    private static class StudentLeaveTime{
        public Integer id;
        public Long leaveTime;
        public String name;
    }
    @Autowired
    public LeaveTimeService(LogManager logManager, StudentManager studentManager, ClassManager classManager, DepartmentManager departmentManager) {
        this.logManager = logManager;
        this.studentManager = studentManager;
        this.classManager = classManager;
        this.departmentManager = departmentManager;
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
            if (result.size() == 0) {
                return new Response<>(Response.SUCCESS, "成功", leaveTime);
            }
            else if (result.get(result.size()-1).getType() == 1) {
                Date date = new Date(System.currentTimeMillis());
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
    public Response<List<Object>> getAllLeaveTime() {
        List<Object> result = new ArrayList<>();
        for (Student student : studentManager.getAllStudent()) {
            StudentLeaveTime studentLeaveTime = new StudentLeaveTime();
            studentLeaveTime.id = student.getId();
            studentLeaveTime.name = student.getName();
            studentLeaveTime.leaveTime = getLeaveTime(student.getId()).getData();
            result.add(studentLeaveTime);
        }
        return new Response<>(Response.SUCCESS, "成功", result);
    }
    public Response<List<Object>> getLeaveTimeByClass(Integer classId) {
        if (classManager.getClassById(classId) == null) {
            return new Response<>(Response.FAIL, "班级不存在", null);
        }
        else {
            List<Object> result = new ArrayList<>();
            for (Student student : studentManager.getStudentByClassId(classId)) {
                StudentLeaveTime studentLeaveTime = new StudentLeaveTime();
                studentLeaveTime.id = student.getId();
                studentLeaveTime.name = student.getName();
                studentLeaveTime.leaveTime = getLeaveTime(student.getId()).getData();
                result.add(studentLeaveTime);
            }
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<List<Object>> getLeaveTimeByDept(Integer deptId) {
        if (departmentManager.getDepartmentById(deptId) == null) {
            return new Response<>(Response.FAIL, "院系不存在", null);
        }
        else {
            List<Object> result = new ArrayList<>();
            for (Student student : studentManager.getStudentByDeptId(deptId)) {
                StudentLeaveTime studentLeaveTime = new StudentLeaveTime();
                studentLeaveTime.id = student.getId();
                studentLeaveTime.name = student.getName();
                studentLeaveTime.leaveTime = getLeaveTime(student.getId()).getData();
                result.add(studentLeaveTime);
            }
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
}
