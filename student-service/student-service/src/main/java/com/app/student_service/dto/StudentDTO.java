package com.app.student_service.dto;

public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private Integer age;

    // ─── Constructors ───────────────────────────────

    public StudentDTO() {}

    public StudentDTO(Long id, String firstName, String lastName,
                      String email, String department, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.age = age;
    }

    // ─── Getters ────────────────────────────────────

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public Integer getAge() { return age; }

    // ─── Setters ────────────────────────────────────

    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
    public void setAge(Integer age) { this.age = age; }
}