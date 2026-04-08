package com.app.course_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private String courseCode;

    private String description;

    private Integer durationWeeks;

    @Column(nullable = false)
    private Long studentId;

    // ─── Constructors ───────────────────────────────

    public Course() {}

    public Course(Long id, String courseName, String courseCode,
                  String description, Integer durationWeeks, Long studentId) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.description = description;
        this.durationWeeks = durationWeeks;
        this.studentId = studentId;
    }

    // ─── Getters ────────────────────────────────────

    public Long getId() { return id; }
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public String getDescription() { return description; }
    public Integer getDurationWeeks() { return durationWeeks; }
    public Long getStudentId() { return studentId; }

    // ─── Setters ────────────────────────────────────

    public void setId(Long id) { this.id = id; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public void setDescription(String description) { this.description = description; }
    public void setDurationWeeks(Integer durationWeeks) { this.durationWeeks = durationWeeks; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
}