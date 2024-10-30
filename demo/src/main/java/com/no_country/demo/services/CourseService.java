package com.no_country.demo.services;

import com.no_country.demo.dto.course.*;
import com.no_country.demo.entities.Course;
import com.no_country.demo.entities.Student;
import com.no_country.demo.entities.Subject;
import com.no_country.demo.repository.SubjectRepository;
import com.no_country.demo.util.mapper.CourseMapper;
import com.no_country.demo.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;
    private SubjectRepository subjectRepository;
    private CourseMapper courseMapper;
    private StudentService studentService;

    //nuevo curso
    public CourseDTO createCourse(CreateCourseDTO courseCreateDTO) {
        Course course = courseMapper.toEntity(courseCreateDTO);
        courseRepository.save(course);
        return courseMapper.toDto(course);
    }
    //get by id
    public Optional<CourseDTO> getCourseById(Long id) {
        return courseRepository.findById(id).map(courseMapper::toDto);
    }
    //get all
    public List<ListCourseDTO> getAllCourses(Pageable pageable) {
        return courseRepository.findAll(pageable).stream()
                .map(courseMapper::toListDto)
                .toList();
    }

    //inscripcion alumno
    public void enrollStudentInCourse(Long studentId, Long courseId) {
        // Buscar el curso por su ID
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + courseId));

        // Buscar el estudiante por su ID
        Student student = studentService.getStudentById(studentId);

        // Verificar si el estudiante fue encontrado
        if (student == null) {
            throw new RuntimeException("Estudiante no encontrado con id: " + studentId);
        }

        // Agregar el estudiante al curso
        course.getStudents().add(student);
        student.setCurrentCourse(course); // Establecer el curso actual del estudiante

        // Guardar los cambios en la base de datos
        courseRepository.save(course);
    }

    public void addSubjectToCourse(Long courseId, Long subjectId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + courseId));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + subjectId));

        // Agregar la asignatura al curso
        course.getSubjects().add(subject);
        // Guardar;
    }
}