package com.example.demo.manager;

import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.entity.Student;
import com.example.demo.model.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ClassManager")
public class ClassManager {
    private final ClassMapper classMapper;
    private final StudentMapper studentMapper;
    @Autowired
    ClassManager(ClassMapper classMapper, StudentMapper studentMapper){
        this.classMapper = classMapper;
        this.studentMapper = studentMapper;
    }
    public List<Class> getClassesByDeptId(Integer id){
        return classMapper.findClassesByDeptId(id);
    }
    public Class getClassByAdminId(Integer Id){
        return classMapper.findClassByAdminId(Id);
    }
    public Class getClassById(Integer Id){
        return classMapper.findClassById(Id);
    }
    public List<Student> getStudentsByClassId(Integer id){
        return studentMapper.findStudentsByClassId(id);
    }
}
