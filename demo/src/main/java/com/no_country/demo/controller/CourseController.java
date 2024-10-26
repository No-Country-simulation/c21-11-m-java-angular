package com.no_country.demo.controller;

import com.no_country.demo.dto.course.*;
import com.no_country.demo.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Operation(
            summary = "Crea un Curso",
            description = "Este endpoint permite crear un Curso"
    )
    @PostMapping("/create")
    public CourseDTO createCourse(@RequestBody CreateCourseDTO courseCreate) {
        return courseService.createCourse(courseCreate);
    }
    @Operation(
            summary = "Obtener/Listar un Curso especifico",
            description = "Este endpoint obtiene la info de un curso especifico"
    )
    @GetMapping("/view/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(
            summary = "Obtener/Listar todos los Cursos",
            description = "Este endpoint obtiene una lista de todos los cursos"
    )
    @GetMapping("/view")
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }
    @Operation(
            summary = "Inscribir Alumnos a Cursos",
            description = "Este endpoint permite inscribir Alumnos a curso"
    )
    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Void> enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.enrollStudentInCourse(courseId, studentId);
        return ResponseEntity.ok().build();
    }
}
