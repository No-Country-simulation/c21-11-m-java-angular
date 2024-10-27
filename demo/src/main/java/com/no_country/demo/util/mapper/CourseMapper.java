package com.no_country.demo.util.mapper;

import com.no_country.demo.dto.course.*;
import com.no_country.demo.entities.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public Course toEntity(CreateCourseDTO courseCreateDTO) {
        return Course.builder()
                .course(courseCreateDTO.nameCourse())
                .detail(courseCreateDTO.detailCourse())
                .subjects(List.of()) // Inicializa con una lista vacía si es necesario
                .students(List.of()) // Inicializa con una lista vacía si es necesario
                .build();
    }

    public CourseDTO toDto(Course course) {
        List<String> subjectNames = course.getSubjects().stream()
                .map(subject -> subject.getSubject()) // Obtener el nombre de la asignatura
                .collect(Collectors.toList());

        List<String> studentFullNames = course.getStudents().stream()
                .map(student -> student.getName() + " " + student.getLastname()) // nombre y apellido
                .collect(Collectors.toList());

        return new CourseDTO(course.getId(),
                course.getCourse(),
                course.getDetail(),
                subjectNames, // Nombres de asignaturas
                studentFullNames); // Nombres completos de estudiantes
    }
}