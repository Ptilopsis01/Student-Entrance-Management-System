package com.example.demo.mapper;

import com.example.demo.model.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper extends JpaRepository<Class, Integer> {
    Class findClassById(int id);
    Class findClassByAdminId(int id);
    List<Class> findClassesByDeptId(int id);
}
