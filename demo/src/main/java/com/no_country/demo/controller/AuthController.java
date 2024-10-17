package com.no_country.demo.controller;

import com.no_country.demo.config.service.UserDetailsServiceImpl;
import com.no_country.demo.dto.auth.LoginRequest;
import com.no_country.demo.dto.auth.StudentRegisterRequest;
import com.no_country.demo.dto.auth.TeacherRegisterRequest;
import com.no_country.demo.dto.auth.response.AuthResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/student")
    public ResponseEntity<?> registerStudent(@RequestBody StudentRegisterRequest request) {
        try {
            userDetailsService.registerStudent(request);  // Método para registrar estudiantes
            return ResponseEntity.ok("Estudiante registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/teacher")
    public ResponseEntity<?> registerTeacher(@RequestBody TeacherRegisterRequest request) {
        try {
            userDetailsService.registerTeacher(request);  // Método para registrar profesores
            return ResponseEntity.ok("Profesor registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login (@Valid @RequestBody LoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailsService.loginUser(userRequest), HttpStatus.OK);
    }
}
