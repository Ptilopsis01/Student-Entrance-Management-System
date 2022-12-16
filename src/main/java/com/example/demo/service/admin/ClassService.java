package com.example.demo.service.admin;

import com.example.demo.manager.ClassManager;
import com.example.demo.manager.DepartmentManager;
import com.example.demo.manager.StudentManager;
import com.example.demo.manager.TeacherManager;
import com.example.demo.model.entity.Student;
import com.example.demo.model.entity.Class;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminClassService")
public class ClassService {
    private final ClassManager classManager;
    private final TeacherManager teacherManager;
    private final StudentManager studentManager;
    private final DepartmentManager departmentManager;
    @Autowired
    public ClassService(ClassManager classManager, TeacherManager teacherManager, StudentManager studentManager, DepartmentManager departmentManager){
        this.classManager = classManager;
        this.teacherManager = teacherManager;
        this.studentManager = studentManager;
        this.departmentManager = departmentManager;
    }
    public Response<Class> getClassByAdminId(Integer Id){
        if (teacherManager.getTeacherById(Id) == null){
            return new Response<>(Response.FAIL, "教师不存在", null);
        }
        else {
            Class result = classManager.getClassByAdminId(Id);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<Class> getClassById(Integer Id){
        if (studentManager.getStudentById(Id) == null){
            return new Response<>(Response.FAIL, "学生不存在", null);
        }
        else {
            Class result = classManager.getClassById(Id);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<List<Class>> getClassesByDeptId(Integer id){
        if (departmentManager.getDepartmentById(id) == null){
            return new Response<>(Response.FAIL, "院系不存在", null);
        }
        else {
            List<Class> result = classManager.getClassesByDeptId(id);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
    public Response<List<Student>> getStudentsByClassId(Integer id){
        if (studentManager.getStudentById(id) == null){
            return new Response<>(Response.FAIL, "学生不存在", null);
        }
        else {
            List<Student> result = classManager.getStudentsByClassId(id);
            return new Response<>(Response.SUCCESS, "成功", result);
        }
    }
}
