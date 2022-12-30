package com.example.demo.service.admin;

import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.model.entity.Class;
import com.example.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClassService")
public class ClassService {
    private final ClassMapper classMapper;
    private final DepartmentMapper departmentMapper;
    @Autowired
    public ClassService(ClassMapper classMapper, DepartmentMapper departmentMapper) {
        this.classMapper = classMapper;
        this.departmentMapper = departmentMapper;
    }
    public Response<List<Class>> getClassesByDeptId(int deptId) {
        if (departmentMapper.findDepartmentById(deptId) == null) {
            return new Response<>(Response.FAIL, "该院系不存在", null);
        }
        else {
            return new Response<>(Response.SUCCESS, "查询成功", classMapper.findClassesByDeptId(deptId));
        }
    }
}
