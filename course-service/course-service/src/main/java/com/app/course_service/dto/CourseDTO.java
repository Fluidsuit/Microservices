package com.app.course_service.dto;

public class CourseDTO {

    private Long id;
    private String courseName;
    private String courseCode;
    private String description;
    private Integer durationWeeks;
    private Long studentId;

    // This holds the student data fetched from student-service
    private StudentInfo student;

    // ─── Constructors ───────────────────────────────

    public CourseDTO() {}

    // ─── Getters ────────────────────────────────────

    public Long getId() { return id; }
    public String getCourseName() { return courseName; }
    public String getCourseCode() { return courseCode; }
    public String getDescription() { return description; }
    public Integer getDurationWeeks() { return durationWeeks; }
    public Long getStudentId() { return studentId; }
    public StudentInfo getStudent() { return student; }

    // ─── Setters ────────────────────────────────────

    public void setId(Long id) { this.id = id; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public void setDescription(String description) { this.description = description; }
    public void setDurationWeeks(Integer durationWeeks) { this.durationWeeks = durationWeeks; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public void setStudent(StudentInfo student) { this.student = student; }

    // ─── Inner class — holds student data from student-service ───

    public static class StudentInfo {

        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String department;
        private Integer age;

        public StudentInfo() {}

        public Long getId() { return id; }
        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getEmail() { return email; }
        public String getDepartment() { return department; }
        public Integer getAge() { return age; }

        public void setId(Long id) { this.id = id; }
        public void setFirstName(String firstName) { this.firstName = firstName; }
        public void setLastName(String lastName) { this.lastName = lastName; }
        public void setEmail(String email) { this.email = email; }
        public void setDepartment(String department) { this.department = department; }
        public void setAge(Integer age) { this.age = age; }
    }
}