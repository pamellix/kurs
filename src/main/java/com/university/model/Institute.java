package com.university.model;

import javax.persistence.*;

@Entity
@Table(name = "institute")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institute_id")
    private Integer instituteId;

    @Column(name = "institute_name", nullable = false)
    private String instituteName;

    @Column(name = "address")
    private String address;

    @Column(name = "director")
    private String director;

    @Column(name = "phone")
    private String phone;

    // Геттеры и сеттеры
    // ...
}