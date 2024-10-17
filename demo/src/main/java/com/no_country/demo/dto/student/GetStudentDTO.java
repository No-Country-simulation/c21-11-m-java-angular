package com.no_country.demo.dto.student;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Builder
public record GetStudentDTO(
        @Schema(example = "1", description = "Student's unique identifier")
        Long id,
        @Schema(example = "John ", description = "Student's updated username")
        String name,
        @Schema(example = "Doe ", description = "Student's updated last name")
        String lastname,
        @Schema(example = "newpassword", description = "Student's updated password")
        String password,
        @Schema(example = "New Locality", description = "Student's updated locality")
        String locality,
        @Length(min = 9, max = 9, message = "dni length 9 digites")
        @Schema(example = "987654321", description = "Student's updated DNI")
        String dni,
        @Schema(example = "New Address", description = "Student's updated address")
        String address,
        @Email(message = "Invalid email address")
        @Schema(example = "johndoed@example.com", description = "Student's updated email address")
        String email,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Schema(example = "1995-01-01", description = "Student's updated birthdate")
        Date birthdate,
        @Schema(example = "1234567890", description = "Student's updated phone number")
        Integer phone,
        @Schema(example = "STUDENT", description = "Student's updated role")
        String rol,
        @Schema(example = "ACTIVE", description = "Student's updated state")
        String userState,
        //String dateRegistrationCourse, hay un manera para que se genere automaticamente cuando se registre al curso
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Schema(example = "2022-01-01", description = "Student's updated current course")
        String currentCourse,
        @Schema(example = "New Tutor", description = "Student's updated tutor")
        String tutor
) {

}
