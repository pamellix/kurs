package com.university.model;

import javax.persistence.*;

@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @Column(name = "discipline_code")
    private Integer disciplineCode;

    @Column(name = "discipline_name", nullable = false)
    private String disciplineName;

    public Integer getDisciplineCode() {
        return disciplineCode;
    }

    public void setDisciplineCode(Integer disciplineCode) {
        this.disciplineCode = disciplineCode;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }
}