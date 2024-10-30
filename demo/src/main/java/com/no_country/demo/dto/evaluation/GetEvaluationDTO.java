package com.no_country.demo.dto.evaluation;

import com.no_country.demo.dto.subject.GetSubjectDTO;
import com.no_country.demo.dto.subject.ListSubjectDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.Date;

@Builder
@Schema(description = "DTO para obtener una evaluación")
public record GetEvaluationDTO(
        @Schema(description = "Identificador único de la evaluación", example = "1")
        Long id,

        @Schema(description = "Asignatura relacionada con la evaluación")
        ListSubjectDTO subject,

        @Schema(description = "Fecha de la evaluación", example = "2022-01-01")
        Date dateEvaluation,

        @Schema(description = "Temas evaluados", example = "Tema 1, Tema 2, Tema 3")
        String topicsEvaluation,

        // @Schema(description = "Calificaciones de la evaluación")
        // List<QualificationDTO> qualifications, //
        @Schema(description = "Comentario de la evaluación", example = "Comentario de la evaluación")
        String comentario,

        @Schema(description = "Estado de activación de la evaluación", example = "true")
        Boolean isActive
) {
}
