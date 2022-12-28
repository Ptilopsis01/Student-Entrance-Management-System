package com.example.demo.mapper;

import com.example.demo.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper extends JpaRepository<Department, Integer> {
    Department findDepartmentById(int id);
    Department findDepartmentByAdminId(int id);
}
