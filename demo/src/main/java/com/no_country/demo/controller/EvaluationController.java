package com.no_country.demo.controller;

import com.no_country.demo.dto.ResponseDTO;
import com.no_country.demo.dto.evaluation.EvaluationDTO;
import com.no_country.demo.dto.evaluation.GetEvaluationDTO;
import com.no_country.demo.dto.evaluation.UpdateEvaluationDTO;
import com.no_country.demo.entities.Evaluation;
import com.no_country.demo.services.EvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;
    @Operation(
            summary = "Crea una nueva Evaluacion",
            description = "el ID de la asignatura/subject es requerido para poder crearse la evaluacion"
    )
    @PostMapping("/create")
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody EvaluationDTO evaluationDTO) {
        Evaluation createdEvaluation = evaluationService.createEvaluation(evaluationDTO);
        return ResponseEntity.ok(createdEvaluation);
    }
    @Operation(
            summary = "Lista Todas las Evaluaciones",
            description = "Este endpoint permite obtener Todas las Evaluaciones Existentes"
    )
    @GetMapping
    public ResponseEntity<List<EvaluationDTO>> getAllEvaluations() {
        List<EvaluationDTO> evaluations = evaluationService.getAllEvaluations();
        return ResponseEntity.ok(evaluations);
    }
    @Operation(
            summary = "Obtener/Listar las Evaluaciones de una Asignatura Especifica",
            description = "Este endpoint permite ver las Evaluaciones de una Asignatura Especifica"
    )
    @GetMapping("/subject/{subjectDTO}")
    public ResponseEntity<List<EvaluationDTO>> getEvaluationsBySubject(@PathVariable Long subjectId) {
        List<EvaluationDTO> evaluations = evaluationService.getEvaluationsBySubject(subjectId);
        return ResponseEntity.ok(evaluations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getEvaluationById(@PathVariable Long id) {
        GetEvaluationDTO evaluation = evaluationService.getEvaluationById(id);
        return ResponseEntity.ok(new ResponseDTO(
                true,
                "La evaluacion se obtubo con exito",
                evaluation
        ));
    }
    @Transactional
    @PatchMapping("/update")
    public ResponseEntity<ResponseDTO> updateEvaluation(@RequestBody UpdateEvaluationDTO updateEvaluationDTO) {
            GetEvaluationDTO evaluationDTO=evaluationService.updateEvaluation(updateEvaluationDTO);
            return ResponseEntity.ok(new ResponseDTO(
                    true,
                    "La evaluacion se actualizo con exito",
                    evaluationDTO
            ));
    }
}