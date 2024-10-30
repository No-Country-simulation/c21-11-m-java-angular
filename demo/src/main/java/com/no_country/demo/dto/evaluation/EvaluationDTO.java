package com.no_country.demo.dto.evaluation;

import com.no_country.demo.entities.enums.QualificationNote;

import java.util.Date;
import java.util.List;

public record EvaluationDTO(
        Long id,
        Long subjectId, //id asignatura
        Date dateEvaluation,
        String topicsEvaluation,
       // List<QualificationDTO> qualifications, //
        String comentario
) {    }
