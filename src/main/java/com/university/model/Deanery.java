package com.university.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "deanery")
public class Deanery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deanery_id")
    private Integer deaneryId;

    @Column(name = "office_number")
    private String officeNumber;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "dean_id")
    private UniversityEmployee dean;

    @ManyToOne
    @JoinColumn(name = "institute_id", nullable = false)
    private Institute institute;

    @Column(name = "establishment_date")
    private LocalDate establishmentDate;

    // Геттеры и сеттеры
    // ...
}