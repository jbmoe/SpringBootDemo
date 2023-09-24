package com.example.demo.student.api;

import com.example.demo.student.Student;
import com.example.demo.student.data.StudentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        try {
            Student student = studentService.getStudent(id);
            return ResponseEntity.ok(student);
        } catch (StudentNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody @NotNull CreateStudentRequest request) {
        Student student = new Student(request.name, request.email, request.dob);
        try {
            studentService.createStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (StudentAlreadyExists e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        } catch (StudentNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody @NotNull UpdateStudentRequest request) {
        try {
            studentService.updateStudent(id, request.name, request.email, request.dob);
            return ResponseEntity.noContent().build();
        } catch (StudentAlreadyExists e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (StudentNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }
}