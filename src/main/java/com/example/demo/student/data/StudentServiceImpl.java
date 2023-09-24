package com.example.demo.student.data;

import com.example.demo.student.Student;
import com.example.demo.student.api.StudentAlreadyExists;
import com.example.demo.student.api.StudentNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) throws StudentNotFound {
        return studentRepository.findById(id).orElseThrow(() -> StudentNotFound.WithId(id));
    }

    public void createStudent(Student student) throws StudentAlreadyExists {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw StudentAlreadyExists.WithEmail(student.getEmail());
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) throws StudentNotFound {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return;
        }
        throw StudentNotFound.WithId(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email, LocalDate dob) throws StudentAlreadyExists, StudentNotFound {
        Student student = studentRepository.findById(id).orElseThrow(() -> StudentNotFound.WithId(id));

        if (name != null && !name.isBlank() && !student.getName().equals(name)) {
            student.setName(name);
        }

        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
        if (studentByEmail.isPresent() && !studentByEmail.get().getId().equals(id)) {
            throw StudentAlreadyExists.WithEmail(studentByEmail.get().getEmail());
        }
        if (email != null && !email.isBlank() && !student.getEmail().equals(email)) {
            student.setEmail(email);
        }

        if (dob != null && dob.isBefore(LocalDate.now()) && !dob.equals(student.getDob())) {
            student.setDob(dob);
        }
    }
}