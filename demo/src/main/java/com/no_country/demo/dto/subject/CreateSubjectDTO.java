package com.no_country.demo.dto.subject;

import com.no_country.demo.entities.enums.DayWeek;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;

public record CreateSubjectDTO(
        @Schema(description = "Name of the subject", example = "Mathematics")
        String name,

        @Schema(description = "Topics of the subject", example = "Algebra, Geometry")
        String topics,

        @Schema(description = "Description of the subject", example = "This is a math subject")
        String description,

        @Schema(description = "Schedule of the subject", example = "2022-01-01 10:00:00")
        Date schedule,

        @Schema(description = "Days of the week for the subject", example = " [\"MONDAY\", \"WEDNESDAY\", \"FRIDAY\"] ")
        List<DayWeek> days)
 {
}
