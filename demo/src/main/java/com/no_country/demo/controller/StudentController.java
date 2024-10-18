package com.no_country.demo.controller;


import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Tag(name = "Student", description = "Controlador de student ")

public class StudentController {
//DELETE STUDENT
//    @Operation(
//            summary = "Desactivar Estudiante",
//            description = "Este endpoint permite crear un nuevo usuario"
//    )
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200",
//                    content = @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = Map.class),
//                            examples = @ExampleObject(value = "{ \"mensaje\": \"el studiante se desactivo exitosamente\" }"))),
//    })
//    @Transactional
//    @PatchMapping("deactivate/{id}")
//    public ResponseEntity<Map<String,String>> deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//        return ResponseEntity.ok(Map.of("mensaje","el studiante se desactivo exitosamente"));
//    }
}
