package com.example.demo.service.admin;

import com.example.demo.manager.ClassManager;
import com.example.demo.manager.DepartmentManager;
import com.example.demo.manager.TeacherManager;
import com.example.demo.model.entity.Class;
import com.example.demo.model.entity.Department;
import com.example.demo.model.entity.Teacher;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminLoginService")
public class AdminLoginService {
    private final TeacherManager teacherManager;
    private final ClassManager classManager;
    private final DepartmentManager departmentManager;
    private static class Admin{
        public Integer id;
        public Integer class_id;
        public Integer department_id;
        public String type;
    }
    @Autowired
    public AdminLoginService(TeacherManager teacherManager, ClassManager classManager, DepartmentManager departmentManager) {
        this.teacherManager = teacherManager;
        this.classManager = classManager;
        this.departmentManager = departmentManager;
    }
    public Response<Object> login(Integer id){
        Teacher teacher = teacherManager.getTeacherById(id);
        Class classInfo = classManager.getClassByAdminId(id);
        Department department = departmentManager.getDepartmentByAdminId(id);
        if(teacher == null){
            return new Response<>(Response.FAIL, "teacher不存在", null);
        }
        else if(classInfo == null && department == null){
            return new Response<>(Response.FAIL, "不是管理员", null);
        }
        else{
            Admin admin = new Admin();
            admin.id = id;
            if(classInfo != null){
                admin.class_id = classInfo.getId();
                admin.type = "class";
            }
            if(department != null){
                admin.department_id = department.getId();
                admin.type = "department";
            }
            return new Response<>(Response.SUCCESS, "登录成功", admin);
        }
    }
}
