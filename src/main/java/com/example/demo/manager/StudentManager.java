package com.example.demo.manager;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("StudentManager")
public class StudentManager {
    private final StudentMapper studentMapper;
    @Autowired
    StudentManager(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }
    public void update(Student student){
          studentMapper.save(student);
    }
    public Student getStudentById(Integer id){
        return studentMapper.findStudentById(id);
    }
}
