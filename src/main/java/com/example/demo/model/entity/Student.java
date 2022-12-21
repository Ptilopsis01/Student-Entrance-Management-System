package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "home")
    private String home;
    @Column(name = "id_type", nullable = false)
    private String idType;
    @Column(name = "id_num", nullable = false)
    private String idNum;
    @Column(name = "status", nullable = false)
    private Integer status;//0/1:校内/校外
    @Column(name = "auth", nullable = false)
    private Integer auth;//0/1:无权限/有权限
    @Column(name = "leave_request", nullable = false)
    private Integer leaveRequest;//0/1:未生效/已生效
    @Column(name = "class_id", nullable = false)
    private Integer classId;
    @Column(name = "dept_id", nullable = false)
    private Integer deptId;
}
