package com.example.demo.student.api;

import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class UpdateStudentRequest {
    public String name;
    public String email;
    @Past
    public LocalDate dob;

    public UpdateStudentRequest() {
    }

    public UpdateStudentRequest(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
}