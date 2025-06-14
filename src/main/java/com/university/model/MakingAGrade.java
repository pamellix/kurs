package com.university.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "making_a_grade")
public class MakingAGrade {
    @EmbeddedId
    private MakingAGradeId id;

    @Column(name = "score", nullable = false)
    private Integer score;

    @Column(name = "exam_date", nullable = false)
    private LocalDate examDate;

    // Геттеры и сеттеры
    // ...
}

@Embeddable
class MakingAGradeId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
}