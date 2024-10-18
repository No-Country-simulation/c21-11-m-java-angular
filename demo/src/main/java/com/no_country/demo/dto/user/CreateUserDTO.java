package com.no_country.demo.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record CreateUserDTO(
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
        String rol,
        Integer file
) {
}
