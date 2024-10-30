package com.no_country.demo.controller;

import com.no_country.demo.dto.ResponseDTO;
import com.no_country.demo.dto.course.*;
import com.no_country.demo.dto.user.student.GetStudentDTO;
import com.no_country.demo.dto.user.teacher.GetTeachertDTO;
import com.no_country.demo.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<ResponseDTO> createCourse(@RequestBody CreateCourseDTO createCourseDTO) {
        return ResponseEntity.ok(new ResponseDTO(
                true
               , "Curso creado exitosamente"
                , courseService.createCourse(createCourseDTO)
        ));
    }
    //------- Obtener/Listar un Curso especifico -------
//    no entendi bien que hace este metodo
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
    //------- Obtener/Listar todos los Cursos -------

    @Operation(
            summary = "Obtener/Listar todos los Cursos",
            description = "Este endpoint obtiene una lista de todos los cursos"
    )

    @GetMapping("/view")
    public ResponseEntity<ResponseDTO> getAllCourses(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
            ){
        Pageable pageable = PageRequest.of(page, size, Sort.unsorted());
        return ResponseEntity.ok(new ResponseDTO(
                true
                , "Listado de Cursos Exitoso"
                , courseService.getAllCourses(pageable)
        ));
    }
    //------- Inscribir Alumnos a Cursos -------
    @Operation(
            summary = "Inscribir Alumnos a Cursos",
            description = "Este endpoint permite inscribir Alumnos a curso"
    )
    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<ResponseDTO> enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.enrollStudentInCourse(studentId, courseId);
        return ResponseEntity.ok(new ResponseDTO(
          true
          ,"Alumno inscripto al curso exitosamenten"
          , null));
    }
    //------- Asignar/Agregar Asignaturas a Curso -------
    @Operation(
            summary = "Asignar/Agregar Asignaturas a Curso",
            description = "Este endpoint permite agregar/asignar materias a curso"
    )
    @Transactional
    @PostMapping("/{courseId}/subjects/{subjectDTO}")
    public ResponseEntity<ResponseDTO> addSubject(@PathVariable Long courseId, @PathVariable Long subjectId) {
        courseService.addSubjectToCourse(courseId, subjectId);
        return ResponseEntity.ok(new ResponseDTO(
                true
                , "Materia asignada Correctamente"
                , null));
    }
}
