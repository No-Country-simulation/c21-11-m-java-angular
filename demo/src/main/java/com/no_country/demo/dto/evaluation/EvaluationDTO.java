package com.no_country.demo.dto.evaluation;

import com.no_country.demo.entities.enums.QualificationNote;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;

public record EvaluationDTO(
        @Schema(description = "Identificador único de la evaluación", example = "1")
        Long id,

        @Schema(description = "Identificador de la asignatura", example = "1")
        Long subjectId, //id asignatura

        @Schema(description = "Fecha de la evaluación", example = "2022-07-25T14:30:00.000Z")
        Date dateEvaluation,

        @Schema(description = "Tópicos de la evaluación", example = "Tema 1, Tema 2, Tema 3")
        String topicsEvaluation,

       // List<QualificationDTO> qualifications, //

        @Schema(description = "Comentario sobre la evaluación", example = "Comentario sobre la evaluación")
        String comentario,

        @Schema(description = "Estado de la evaluación", example = "true")
        Boolean isActive
) {

}
