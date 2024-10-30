package com.no_country.demo.dto.subject;

import com.no_country.demo.entities.enums.DayWeek;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.Date;
import java.util.List;
@Builder
public record GetSubjectDTO(
        @Schema(description = "ID de la asignatura", example = "1")
        Long id,

        @Schema(description = "Nombre de la asignatura", example = "Matemáticas")
        String subject,

        @Schema(description = "ID del profesor", example = "2")
        Long teacherId,

        @Schema(description = "Temas cubiertos en la asignatura", example = "Álgebra, Cálculo")
        String topics,

        @Schema(description = "Descripción de la asignatura", example = "Conceptos matemáticos básicos")
        String description,

        @Schema(description = "Fecha de programación", example = "2022-01-01T12:00:00.000Z")
        Date schedule,

        @Schema(description = "Días de la semana en que se imparte la asignatura", example = "LUNES, MARTES")
        List<DayWeek> days,

        @Schema(description = "IDs de evaluaciones asociadas con la asignatura", example = "[1, 2, 3]")
        List<Long> evaluationIds,

        @Schema(description = "IDs de cursos asociados con la asignatura", example = "[4, 5, 6]")
        List<Long> courseIds
) {
}
