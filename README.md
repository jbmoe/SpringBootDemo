# Spring Boot Student CRUD API

This project is a simple Spring Boot application that demonstrates the usage of Spring Web and Spring Data JPA to create a CRUD (Create, Read, Update, Delete) API for managing student records.

## Features

- Create a new student record.
- Retrieve a list of all students.
- Retrieve a specific student by ID.
- Update an existing student's information.
- Delete a student record.

## API Endpoints

- **GET /students**: Retrieve a list of all students.
- **GET /students/{id}**: Retrieve a specific student by ID.
- **POST /students**: Create a new student record.
  - Request Body: JSON representation of the student.
- **PUT /students/{id}**: Update an existing student's information.
  - Request Body: JSON representation of the updated student.
- **DELETE /students/{id}**: Delete a student record.

## Technologies Used

This project makes use of the following technologies and libraries:

- **Spring Boot**: The framework used for building the application.
- **Spring Data JPA**: For simplifying database access and data persistence.
- **Spring Web**: For building RESTful APIs and handling HTTP requests.
- **PostgreSQL**: The relational database used to store data (runtime dependency).
- **Jakarta Validation API**: For validation purposes (version 3.0.2).
- **Java**: The programming language used (version 21).
