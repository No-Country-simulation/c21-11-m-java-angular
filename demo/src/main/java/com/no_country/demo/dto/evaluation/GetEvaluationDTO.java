package com.no_country.demo.dto.evaluation;

import com.no_country.demo.dto.subject.GetSubjectDTO;
import com.no_country.demo.dto.subject.ListSubjectDTO;
import lombok.Builder;

import java.util.Date;

@Builder
public record GetEvaluationDTO(
        Long id,
        ListSubjectDTO subject, //id asignatura
        Date dateEvaluation,
        String topicsEvaluation,
        // List<QualificationDTO> qualifications, //
        String comentario
) {
}
