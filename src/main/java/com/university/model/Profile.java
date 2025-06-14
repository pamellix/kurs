package com.university.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "profile_name", nullable = false)
    private String profileName;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "specialty_id", nullable = false)
    private Specialty specialty;

    @Column(name = "inclusion_date")
    private LocalDate inclusionDate;

    // Геттеры и сеттеры
    // ...
}