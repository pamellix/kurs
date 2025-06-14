package com.university.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialty_id")
    private Integer specialtyId;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @Column(name = "inclusion_date")
    private LocalDate inclusionDate;

    @Column(name = "specialty_name", nullable = false)
    private String specialtyName;

    // Геттеры и сеттеры
    // ...
}