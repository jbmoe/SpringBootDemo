package com.example.demo.student.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class CreateStudentRequest {
    @NotBlank
    @NotNull
    public String name;
    @NotNull
    @NotBlank
    @Email
    public String email;
    @NotNull
    @Past
    public LocalDate dob;

    public CreateStudentRequest() {
    }

    public CreateStudentRequest(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
}