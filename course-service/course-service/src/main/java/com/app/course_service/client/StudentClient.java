package com.app.course_service.client;

import com.app.course_service.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("/api/students/{id}")
    CourseDTO.StudentInfo getStudentById(@PathVariable("id") Long id);

}