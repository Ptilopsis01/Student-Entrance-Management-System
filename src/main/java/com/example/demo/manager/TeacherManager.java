package com.example.demo.manager;

import com.example.demo.mapper.TeacherMapper;
import com.example.demo.model.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("TeacherManager")
public class TeacherManager {
    private final TeacherMapper teacherMapper;
    @Autowired
    TeacherManager(TeacherMapper teacherMapper){
        this.teacherMapper = teacherMapper;
    }
    public Teacher getTeacherById(Integer id){
        return teacherMapper.findTeacherById(id);
    }
}
