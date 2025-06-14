package com.university.model;

import javax.persistence.*;

@Entity
@Table(name = "university_employee")
public class UniversityEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "academic_degree", nullable = false)
    private String academicDegree;

    @Column(name = "email")
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "position", nullable = false)
    private String position;

    // Геттеры и сеттеры
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getAcademicDegree() { return academicDegree; }
    public void setAcademicDegree(String academicDegree) { this.academicDegree = academicDegree; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}