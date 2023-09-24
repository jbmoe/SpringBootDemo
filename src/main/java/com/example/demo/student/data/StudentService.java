package com.example.demo.student.data;

import com.example.demo.student.Student;
import com.example.demo.student.api.StudentAlreadyExists;
import com.example.demo.student.api.StudentNotFound;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(Long id) throws StudentNotFound;

    void createStudent(Student student) throws StudentAlreadyExists;

    void deleteStudent(Long id) throws StudentNotFound;

    void updateStudent(Long id, String name, String email, LocalDate dob) throws StudentAlreadyExists, StudentNotFound;
}