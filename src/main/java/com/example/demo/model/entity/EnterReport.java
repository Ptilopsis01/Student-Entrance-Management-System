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
    @Column(name = "class_id", nullable = false)
    private Integer classId;
    @Column(name = "dept_id", nullable = false)
    private Integer deptId;
    @Column(name = "sub_time", nullable = false)
    private Date subTime;
    @Column(name = "reason", nullable = false)
    private String reason;
    @Column(name = "status", nullable = false)
    private Integer status;//0/1/2:未通过/通过/未审核
    @Column(name = "region", nullable = false)
    private String region;
    @Column(name = "ref_reason")
    private String refReason;
}
