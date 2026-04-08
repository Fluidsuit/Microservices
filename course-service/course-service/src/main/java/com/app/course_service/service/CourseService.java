package com.app.course_service.service;

import com.app.course_service.client.StudentClient;
import com.app.course_service.dto.CourseDTO;
import com.app.course_service.model.Course;
import com.app.course_service.repository.CourseRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    // ─── CREATE ─────────────────────────────────────

    public CourseDTO createCourse(CourseDTO dto) {

        CourseDTO.StudentInfo student = studentClient.getStudentById(dto.getStudentId());

        if (student == null) {
            throw new RuntimeException("Student not found with id: "
                    + dto.getStudentId()
                    + " — create the student in student-service first!");
        }

        if (courseRepository.existsByCourseCode(dto.getCourseCode())) {
            throw new RuntimeException("Course code "
                    + dto.getCourseCode() + " already exists!");
        }

        Course saved = courseRepository.save(mapToEntity(dto));
        CourseDTO response = mapToDTO(saved);
        response.setStudent(student);
        return response;
    }

    // ─── GET ALL ─────────────────────────────────────

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(course -> {
                    CourseDTO dto = mapToDTO(course);
                    // Feign call — clean and simple
                    CourseDTO.StudentInfo student =
                            studentClient.getStudentById(course.getStudentId());
                    dto.setStudent(student);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // ─── GET BY ID ───────────────────────────────────

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Course not found with id: " + id));

        CourseDTO dto = mapToDTO(course);

        // One simple line — Feign calls student-service automatically
        CourseDTO.StudentInfo student =
                studentClient.getStudentById(course.getStudentId());
        dto.setStudent(student);
        return dto;
    }

    // ─── GET BY STUDENT ──────────────────────────────

    public List<CourseDTO> getCoursesByStudentId(Long studentId) {

        // Verify student exists — Feign call
        CourseDTO.StudentInfo student = studentClient.getStudentById(studentId);

        if (student == null) {
            throw new RuntimeException("Student not found with id: " + studentId);
        }

        return courseRepository.findByStudentId(studentId)
                .stream()
                .map(course -> {
                    CourseDTO dto = mapToDTO(course);
                    dto.setStudent(student);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // ─── UPDATE ──────────────────────────────────────

    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Course not found with id: " + id));

        existing.setCourseName(dto.getCourseName());
        existing.setCourseCode(dto.getCourseCode());
        existing.setDescription(dto.getDescription());
        existing.setDurationWeeks(dto.getDurationWeeks());
        existing.setStudentId(dto.getStudentId());

        Course updated = courseRepository.save(existing);
        CourseDTO response = mapToDTO(updated);

        // Feign call
        response.setStudent(studentClient.getStudentById(updated.getStudentId()));
        return response;
    }

    // ─── DELETE ──────────────────────────────────────

    public String deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
        return "Course with id " + id + " deleted successfully!";
    }

    // ─── MAPPERS ─────────────────────────────────────

    private CourseDTO mapToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCourseName(course.getCourseName());
        dto.setCourseCode(course.getCourseCode());
        dto.setDescription(course.getDescription());
        dto.setDurationWeeks(course.getDurationWeeks());
        dto.setStudentId(course.getStudentId());
        return dto;
    }

    private Course mapToEntity(CourseDTO dto) {
        Course course = new Course();
        course.setCourseName(dto.getCourseName());
        course.setCourseCode(dto.getCourseCode());
        course.setDescription(dto.getDescription());
        course.setDurationWeeks(dto.getDurationWeeks());
        course.setStudentId(dto.getStudentId());
        return course;
    }
}