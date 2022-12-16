package com.example.demo.mapper;

import com.example.demo.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherById(Integer id);
}

