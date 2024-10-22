package com.no_country.demo.controller;

import com.no_country.demo.dto.course.*;
import com.no_country.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public CourseDTO createCourse(@RequestBody CreateCourseDTO courseCreate) {
        return courseService.createCourse(courseCreate);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/view")
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Void> enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.enrollStudentInCourse(courseId, studentId);
        return ResponseEntity.ok().build();
    }
}
