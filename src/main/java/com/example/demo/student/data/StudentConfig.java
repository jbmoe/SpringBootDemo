package com.example.demo.student.data;

import com.example.demo.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new Student("Jeppe Bach Møller", "jeppe@email.com", LocalDate.of(1997, 9, 19)),
                    new Student("Ben Dover", "ben@email.com", LocalDate.of(1985, 7, 23)),
                    new Student("Chris P. Bacon", "chris@email.com", LocalDate.of(2005, 12, 6))));
        };
    }
}