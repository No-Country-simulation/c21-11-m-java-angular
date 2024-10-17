package com.no_country.demo.controller;

import com.no_country.demo.dto.student.CreateStudentDTO;
import com.no_country.demo.dto.student.GetStudentDTO;
import com.no_country.demo.dto.student.UpdateStudentDTO;
import com.no_country.demo.entities.Student;
import com.no_country.demo.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Tag(name = "Student", description = "Controlador de student ")

public class StudentController {

    private final StudentService studentService;

    //CREATE STUDENT
    @Operation(
            summary = "Crea un nuevo usuario",
            description = "Este endpoint permite crear un nuevo usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class),
                            examples = @ExampleObject(value = "{ \"mensaje\": \"el usuario se creo correctamente\" }"))),
    })
    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createStudent(@Valid @RequestBody CreateStudentDTO createStudentDTO) {
        studentService.createStudent(createStudentDTO);
        return ResponseEntity.ok(Map.of("mensaje", "el usuario se creo correctamente"));
    }

    //    OBTENER STUDENT
    @Operation(
            summary = "Optener Estudiante",
            description = "Este endpoint permite crear un nuevo usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetStudentDTO.class))),
    })
    @GetMapping("/{id}")
    public ResponseEntity<GetStudentDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentDTO(id));
    }

    //    UPDATE STUDENT
    @Operation(
            summary = "Actualizar Estudiante",
            description = "Este endpoint permite crear un nuevo usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class),
                            examples = @ExampleObject(value = "{ \"mensaje\": \"el usuario se actualizo correct\" }"))),
    })
    @Transactional
    @PatchMapping("/update/{id}")
    public ResponseEntity<Map<String,String>> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStudentDTO updateStudentDTO) {
        studentService.updateStudent(id, updateStudentDTO);
        return ResponseEntity.ok(Map.of("mensaje", "el usuario se actualizo correct"));
    }
//DELETE STUDENT
    @Operation(
            summary = "Desactivar Estudiante",
            description = "Este endpoint permite crear un nuevo usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class),
                            examples = @ExampleObject(value = "{ \"mensaje\": \"el studiante se desactivo exitosamente\" }"))),
    })
    @Transactional
    @PatchMapping("deactivate/{id}")
    public ResponseEntity<Map<String,String>> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(Map.of("mensaje","el studiante se desactivo exitosamente"));
    }
}
