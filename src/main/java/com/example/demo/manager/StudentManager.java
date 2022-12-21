package com.example.demo.manager;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public List<Student> getAllStudent(){
        return studentMapper.findAll();
    }
    public List<Student> getStudentByClassId(Integer classId){
        return studentMapper.findStudentsByClassId(classId);
    }
    public List<Student> getStudentByDeptId(Integer deptId){
        return studentMapper.findStudentsByDeptId(deptId);
    }
}
