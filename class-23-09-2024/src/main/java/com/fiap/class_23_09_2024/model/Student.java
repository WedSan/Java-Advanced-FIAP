package com.fiap.class_23_09_2024.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String schoolRegistration;

    private String name;

    private LocalDate birthDate;

    private String course;

    private String email;

    private String document;

    public Student() {
    }

    public Student(String name, LocalDate birthDate, String course, String email, String document) {
        this.name = name;
        this.course = course;
        this.email = email;
        this.document = document;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolRegistration() {
        return schoolRegistration;
    }

    public void setSchoolRegistration(String schoolRegistration) {
        this.schoolRegistration = schoolRegistration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
