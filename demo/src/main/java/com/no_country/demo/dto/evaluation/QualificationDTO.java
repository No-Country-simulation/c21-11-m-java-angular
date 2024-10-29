package com.no_country.demo.dto.evaluation;

import com.no_country.demo.entities.enums.QualificationNote;

public record QualificationDTO(
        Long id,
        Long studentId, // ID del alumno
        String studentName, // Nombre del alumno
        Long evaluationId, // ID de la evaluación
        String evaluationDate, // Fecha de la evaluación
        String subjectName, // Nombre de la asignatura
        QualificationNote note, // Nota del alumno
        String comentario // Comentario adicional
) {}
