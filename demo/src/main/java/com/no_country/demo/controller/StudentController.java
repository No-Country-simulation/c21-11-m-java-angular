package com.no_country.demo.controller;


import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
@AllArgsConstructor
@Tag(name = "Student", description = "Controlador de student ")

public class StudentController {

}
