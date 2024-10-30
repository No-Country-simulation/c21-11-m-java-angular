package com.no_country.demo.dto.evaluation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.Date;
import java.util.List;
@Builder
public record ListEvaluationDTO(
        @Schema(description = "Unique identifier of the evaluation", example = "1")
        Long id,
        @Schema(description = "Id of the related subject", example = "10")
        Long subjectId, //id asignatura
        @Schema(description = "Date of the evaluation", example = "2022-01-01")
        Date dateEvaluation,
        @Schema(description = "Topics covered in the evaluation", example = "Math, Science")
        String topicsEvaluation,
//        @Schema(description = "List of qualifications", example = "[{id: 1, qualification: 80}, {id: 2, qualification: 90}]")
//        List<QualificationDTO> qualifications,
        @Schema(description = "Comment or feedback about the evaluation", example = "Good job!")
        String comentario
) {

}
