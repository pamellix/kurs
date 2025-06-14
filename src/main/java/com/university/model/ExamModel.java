package com.university.model;

import java.time.LocalDate;

public class ExamModel {
    private LocalDate examDate;
    private String examType;
    private String groupName;
    private String disciplineName;

    // Конструктор
    public ExamModel(LocalDate examDate, String examType, String groupName, String disciplineName) {
        this.examDate = examDate;
        this.examType = examType;
        this.groupName = groupName;
        this.disciplineName = disciplineName;
    }

    // Геттеры
    public LocalDate getExamDate() { return examDate; }
    public String getExamType() { return examType; }
    public String getGroupName() { return groupName; }
    public String getDisciplineName() { return disciplineName; }
}