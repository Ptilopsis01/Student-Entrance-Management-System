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

@Service("StudentService")
public class StudentService {
    private final StudentManager studentManager;
    private final LogManager logManager;
    private final ClassManager classManager;
    private final DepartmentManager departmentManager;
    private static class LeftStudent{
        public Integer id;
        public String name;
        public String phone;
        public String email;
        public String address;
        public String home;
        public String idType;
        public String idNum;
        public String dept;
        public String className;
        public Long leaveTime;
    }
    @Autowired
    public StudentService(StudentManager studentManager, LogManager logManager, ClassManager classManager, DepartmentManager departmentManager) {
        this.studentManager = studentManager;
        this.logManager = logManager;
        this.classManager = classManager;
        this.departmentManager = departmentManager;
    }
    public Long getStudentLeaveTime(Integer id){
        List<Log> log = logManager.getLogByStuId(id);
        Date date = new Date(System.currentTimeMillis());
        if (log.size() == 0){
            return 0L;
        }
        else {
            long time = date.getTime() - log.get(log.size() - 1).getTime().getTime();
            return time / (1000 * 60);
        }
    }
    public Response<List<Object>> getLeftStudent(){
        List<Object> result = new ArrayList<>();
        List<Student> student = studentManager.getStudentByStatus(1);
        for (Student stu : student){
            LeftStudent leftStudent = new LeftStudent();
            leftStudent.id = stu.getId();
            leftStudent.name = stu.getName();
            leftStudent.phone = stu.getPhone();
            leftStudent.email = stu.getEmail();
            leftStudent.address = stu.getAddress();
            leftStudent.home = stu.getHome();
            leftStudent.idType = stu.getIdType();
            leftStudent.idNum = stu.getIdNum();
            leftStudent.dept = departmentManager.getDepartmentById(stu.getDeptId()).getName();
            leftStudent.className = classManager.getClassById(stu.getClassId()).getName();
            leftStudent.leaveTime = getStudentLeaveTime(stu.getId());
            result.add(leftStudent);
        }
        return new Response<>(Response.SUCCESS, "成功", result);
    }
    public Response<List<Student>> getLeftStudentNoRequest(){
        List<Student> student = studentManager.getStudentByStatus(1);
        List<Student> result = new ArrayList<>();
        for (Student stu : student){
            if (getStudentLeaveTime(stu.getId()) > 24*60 && stu.getLeaveRequest() == 0){
                result.add(stu);
            }
        }
        return new Response<>(Response.SUCCESS, "成功", result);
    }
}
