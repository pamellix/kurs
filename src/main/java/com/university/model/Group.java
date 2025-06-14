package com.university.model;

import javax.persistence.*;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "course_number", nullable = false)
    private Integer courseNumber;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "enrollment_year")
    private Integer enrollmentYear;

    // Геттеры и сеттеры
    // ...
}