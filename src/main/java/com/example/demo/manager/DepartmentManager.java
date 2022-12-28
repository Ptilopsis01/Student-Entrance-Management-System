package com.example.demo.manager;

import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.model.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("DepartmentManager")
public class DepartmentManager {
    private final DepartmentMapper departmentMapper;
    @Autowired
    DepartmentManager(DepartmentMapper departmentMapper){
        this.departmentMapper = departmentMapper;
    }
    public Department getDepartmentById(Integer id){
        return departmentMapper.findDepartmentById(id);
    }
    public Department getDepartmentByAdminId(Integer id){
        return departmentMapper.findDepartmentByAdminId(id);
    }
}
