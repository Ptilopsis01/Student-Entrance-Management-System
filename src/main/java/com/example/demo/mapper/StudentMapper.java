package com.example.demo.mapper;

import com.example.demo.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
}
