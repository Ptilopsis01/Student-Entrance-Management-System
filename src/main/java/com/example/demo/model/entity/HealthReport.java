package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "health_report")
public class HealthReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "stu_id", nullable = false)
    private Integer stuId;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "condition", nullable = false)
    private String condition;
    @Column(name = "position", nullable = false)
    private String position;
}
