package com.no_country.demo.dto.student;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

public record CreateStudentDTO(
//        @NotBlank(message = "username required")
//        @Length(min = 1, max = 50, message = "Username must be between 1 and 255 characters")
        @Schema(example = "John", description = "Student's username")
        String name,
        @Schema(example = "Doe", description = "Student's last name")
        String lastname,
        @Email(message = "Invalid email address")
        @NotNull
        @Schema(example = "johndoe@example.com", description = "Student's email address")
        String email,
        @Length(min = 9, max = 9, message = "dni length 9 digites")
        @Schema(example = "123456789", description = "Student's DNI")
        String dni,
//        String address,
        @Schema(example = "1990-01-01", description = "Student's birthdate")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date birthdate,
        @NotEmpty(message = "At least one role is required")
        @Schema(example = "STUDENT", description = "Student's role")
        String rol
) {
}
