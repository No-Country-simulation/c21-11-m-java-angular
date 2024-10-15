package com.no_country.demo.dto.student;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


public record CreateStudentDTO(
        @NotBlank(message = "username required")
        @Size(min = 1, max = 50, message = "Username must be between 1 and 255 characters")
        String name,
        String lastname,
        @Length(min = 4, max = 8, message = "Password min 8 and max 20")
        @NotBlank String password,
        @Email(message = "Invalid email address")
        @NotNull String email,
        Integer dni,
//        String address,
        Date birthdate,
        @NotEmpty(message = "At least one role is required")
        String rol
) {
}

