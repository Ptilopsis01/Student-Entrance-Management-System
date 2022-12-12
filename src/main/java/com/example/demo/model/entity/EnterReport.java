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
@Table(name = "enter_report")
public class EnterReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "stu_id", nullable = false)
    private Integer stuId;
    @Column(name = "sub_time", nullable = false)
    private Date subTime;
    @Column(name = "reason", nullable = false)
    private String reason;
    @Column(name = "status", nullable = false)
    private Integer status;//0/1/2/3:未审核/通过/未通过/已失效
    @Column(name = "region", nullable = false)
    private String region;
}
