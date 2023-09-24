package com.example.demo.student.api;

public class StudentNotFound extends Exception {
    private StudentNotFound(String message) {
        super(message);
    }

    public static StudentNotFound WithId(Long id) {
        return new StudentNotFound("Student with id %d does not exists".formatted(id));
    }
}