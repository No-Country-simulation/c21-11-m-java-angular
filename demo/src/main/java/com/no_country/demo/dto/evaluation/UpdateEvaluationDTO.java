package com.no_country.demo.dto.evaluation;

import com.no_country.demo.dto.subject.GetSubjectDTO;

import java.util.Date;

public record UpdateEvaluationDTO (
        Long id, // id evaluación
        Long subjectID, //id asignatura
        Date dateEvaluation,
        String topicsEvaluation,
        // List<QualificationDTO> qualifications, //
        String comentario
){
}
