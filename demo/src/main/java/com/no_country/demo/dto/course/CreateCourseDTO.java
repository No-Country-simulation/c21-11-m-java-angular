package com.no_country.demo.dto.course;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateCourseDTO (
        @Schema(example = "1-A", description = "Nombre del curso")
        String nameCourse,
        @Schema(example = "Este curso es una introducción a los conceptos fundamentales de la educación primaria", description = "Descripción del curso")
        String detailCourse
) {
}
