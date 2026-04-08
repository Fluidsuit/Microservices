package com.app.student_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
        System.out.println("========================================");
        System.out.println("  Student Service started on port 8080 ");
        System.out.println("  http://localhost:8080/api/students     ");
        System.out.println("========================================");
    }
}