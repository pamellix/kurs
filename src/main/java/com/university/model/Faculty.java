package com.university.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private Integer facultyId;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = false)
    private Institute institute;

    @Column(name = "inclusion_date")
    private LocalDate inclusionDate;

    // Геттеры и сеттеры
    // ...
}