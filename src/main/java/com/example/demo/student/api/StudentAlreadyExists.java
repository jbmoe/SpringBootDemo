package com.example.demo.student.api;

public class StudentAlreadyExists extends Exception {
    private StudentAlreadyExists(String message) {
        super(message);
    }

    public static StudentAlreadyExists WithEmail(String email) {
        return new StudentAlreadyExists("Student with email %s already exists".formatted(email));
    }
}