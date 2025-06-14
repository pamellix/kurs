package com.university.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "office_number", nullable = false)
    private Integer officeNumber;

    @ManyToOne
    @JoinColumn(name = "chairperson_id")
    private UniversityEmployee chairperson;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @Column(name = "establishment_date")
    private LocalDate establishmentDate;

    // Геттеры и сеттеры
    // ...
}