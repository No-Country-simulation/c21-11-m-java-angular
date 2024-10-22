package com.no_country.demo.services;

import com.no_country.demo.dto.course.*;
import com.no_country.demo.entities.Course;
import com.no_country.demo.entities.Student;
import com.no_country.demo.util.mapper.CourseMapper;
import com.no_country.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentService studentService;

    //nuevo curso
    public CourseDTO createCourse(CreateCourseDTO courseCreateDTO) {
        Course course = courseMapper.toEntity(courseCreateDTO);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDto(savedCourse);
    }
    //get by id
    public Optional<CourseDTO> getCourseById(Long id) {
        return courseRepository.findById(id).map(courseMapper::toDto);
    }
    //get all
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .toList();
    }

    //inscripcion alumno
    public void enrollStudentInCourse(Long studentId, Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + courseId));

        // buscar el estudiante por su ID
        Student student = studentService.getStudentById(studentId);

        // Agrega el estudiante al curso
        course.getStudents().add(student);
        student.setCurrentCourse(course); // Establecer el curso actual del estudiante

        // Guardar los cambios en la base de datos
        courseRepository.save(course);
    }
}