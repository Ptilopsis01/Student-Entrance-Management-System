package com.example.demo.manager;

import com.example.demo.mapper.EnterReportMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.entity.EnterReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("EnterReportManager")
public class EnterReportManager {
    private final EnterReportMapper enterReportMapper;
    private final StudentMapper studentMapper;
    private static class EnterReportCount{
        public Integer id;
        public String name;
        public Integer count;
    }
    @Autowired
    public EnterReportManager(EnterReportMapper enterReportMapper, StudentMapper studentMapper) {
        this.enterReportMapper = enterReportMapper;
        this.studentMapper = studentMapper;
    }
    public void save(EnterReport enterReport){
        enterReportMapper.save(enterReport);
    }
    public EnterReport findEnterReportById(Integer id){
        return enterReportMapper.findEnterReportById(id);
    }
    public List<EnterReport> findEnterReportByStuId(Integer id){
        return enterReportMapper.findEnterReportByStuId(id);
    }
    public List<EnterReport> findEnterReportByClassId(Integer id){
        return enterReportMapper.findEnterReportByClassId(id);
    }
    public List<EnterReport> findEnterReportByDeptId(Integer id){
        return enterReportMapper.findEnterReportByDeptId(id);
    }
    public List<EnterReport> findEnterReportByStatus(Integer status){
        return enterReportMapper.findEnterReportByStatus(status);
    }
    public List<Object> countAllEnterReport(){
        List<Object> list = new ArrayList<>();
        studentMapper.findAll().forEach(student -> {
            EnterReportCount object = new EnterReportCount();
            object.id = student.getId();
            object.name = student.getName();
            object.count = enterReportMapper.countByStuId(student.getId());
            list.add(object);
        });
        return list;
    }
    public List<Object> countEnterReportByClassId(Integer id){
        List<Object> list = new ArrayList<>();
        studentMapper.findStudentsByClassId(id).forEach(student -> {
            EnterReportCount object = new EnterReportCount();
            object.id = student.getId();
            object.name = student.getName();
            object.count = enterReportMapper.countByStuId(student.getId());
            list.add(object);
        });
        return list;
    }
    public List<Object> countEnterReportByDeptId(Integer id){
        List<Object> list = new ArrayList<>();
        studentMapper.findStudentsByDeptId(id).forEach(student -> {
            EnterReportCount object = new EnterReportCount();
            object.id = student.getId();
            object.name = student.getName();
            object.count = enterReportMapper.countByStuId(student.getId());
            list.add(object);
        });
        return list;
    }
}
