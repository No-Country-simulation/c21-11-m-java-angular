package com.no_country.demo.controller;

import com.no_country.demo.dto.evaluation.QualificationDTO;
import com.no_country.demo.entities.Qualification;
import com.no_country.demo.services.QualificationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/qualification")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;
    @Operation(
            summary = "Crea una calificacion por Alumno y Evaluacion",
            description = "Este endpoint crear una calificacion"
    )
    @PostMapping
    public ResponseEntity<Qualification> createQualification(@RequestBody QualificationDTO qualificationDTO) {
        Qualification createdQualification = qualificationService.createQualification(qualificationDTO);
        return ResponseEntity.ok(createdQualification);
    }
    @Operation(
            summary = "Obtener Calificaciones por Evaluacion",
            description = "Este endpoint permite obtener/listar calificaciones por evaluacion"
    )
    @GetMapping("/evaluation/{evaluationId}")
    public ResponseEntity<List<QualificationDTO>> getQualificationsByEvaluation(@PathVariable Long evaluationId) {
        List<QualificationDTO> qualifications = qualificationService.getQualificationsByEvaluation(evaluationId);
        return ResponseEntity.ok(qualifications);
    }
    @Operation(
            summary = "Obtener Calificaciones por Alumno",
            description = "Este endpoint permite obtener/listar calificaciones por Alumno"
    )
    @GetMapping("/students/{studentId}/qualifications")
    public ResponseEntity<List<QualificationDTO>> getQualifications(@PathVariable Long studentId) {
        List<QualificationDTO> qualifications = qualificationService.getQualificationsByStudent(studentId);
        return ResponseEntity.ok(qualifications);
    }
    @Operation(
            summary = "Elimina una calificacion",
            description = "Este endpoint elimina una calificacion"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQualification(@PathVariable Long id) {
        qualificationService.deleteQualification(id);
        return ResponseEntity.noContent().build();
    }
}
