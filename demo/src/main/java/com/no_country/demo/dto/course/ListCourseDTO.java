package com.no_country.demo.dto.course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record ListCourseDTO(
        @Schema(example = "1", description = "ID del curso")
        Long id,
        @Schema(example = "Curso de Introducción a la Educación Primaria", description = "Nombre del curso")
        String nameCourse,
        @Schema(example = "Este curso es una introducción a los conceptos fundamentales de la educación primaria", description = "Descripción del curso")
        String description
) {
}
