package com.app.student_service.service;

import com.app.student_service.dto.StudentDTO;
import com.app.student_service.model.Student;
import com.app.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // ─── CREATE ─────────────────────────────────────

    public StudentDTO createStudent(StudentDTO dto) {

        if (studentRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Student with email "
                    + dto.getEmail() + " already exists!");
        }

        Student student = mapToEntity(dto);
        Student saved = studentRepository.save(student);
        return mapToDTO(saved);
    }

    // ─── GET ALL ─────────────────────────────────────

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ─── GET BY ID ───────────────────────────────────

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Student not found with id: " + id));
        return mapToDTO(student);
    }

    // ─── GET BY DEPARTMENT ───────────────────────────

    public List<StudentDTO> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ─── UPDATE ──────────────────────────────────────

    public StudentDTO updateStudent(Long id, StudentDTO dto) {

        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Student not found with id: " + id));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setDepartment(dto.getDepartment());
        existing.setAge(dto.getAge());

        Student updated = studentRepository.save(existing);
        return mapToDTO(updated);
    }

    // ─── DELETE ──────────────────────────────────────

    public String deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
        return "Student with id " + id + " deleted successfully!";
    }

    // ─── MAPPERS ─────────────────────────────────────

    private StudentDTO mapToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setDepartment(student.getDepartment());
        dto.setAge(student.getAge());
        return dto;
    }

    private Student mapToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());
        student.setAge(dto.getAge());
        return student;
    }
}