package com.university.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "exam")

public class Exam {
    public void setExamId(int examId) {
        this.examId = examId;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public int getExamId() {
        return examId;
    }

    public String getExamType() {
        return examType;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getGroupId() {
        return groupId;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Date getExamDate() {
        return examDate;
    }

    public Integer getSemester() {
        return semester;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private int examId;

    @Column(name = "exam_type", nullable = false)
    private String examType;

    @Column(name = "employee_id", nullable = false)
    private int employeeId;

    @Column(name = "group_id", nullable = false)
    private int groupId;

    @ManyToOne
    @JoinColumn(name = "discipline_code", nullable = false)
    private Discipline discipline;

    @Column(name = "exam_date")
    private Date examDate;

    @Column(name = "semester")
    private Integer semester;


}