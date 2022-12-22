package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "stu_id", nullable = false)
    private Integer stuId;
    @Column(name = "class_id", nullable = false)
    private Integer classId;
    @Column(name = "dept_id", nullable = false)
    private Integer deptId;
    @Column(name = "camp_id", nullable = false)
    private Integer campId;
    @Column(name = "time", nullable = false)
    private Timestamp time;
    @Column(name = "type", nullable = false)
    private Integer type;//0/1:进入/离开
}
