package com.no_country.demo.dto.student;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record UpdateStudentDTO(

        String name,
        String lastname,
        String password,
        String locality,
        String dni,
        String address,
        String email,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        Date birthdate,
        int phone,
        String rol,
        String userState,
        Boolean statusStudent,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
//        String dateRegistrationCourse, hay un manera para que se genere automaticamente cuando se registre al curso
        String currentCourse,
        String tutor
) {

}
