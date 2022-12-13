package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name = "sub_date", nullable = false)
    private String subDate;
    @Column(name = "health", nullable = false)
    private String health;
    @Column(name = "location", nullable = false)
    private String location;
}
