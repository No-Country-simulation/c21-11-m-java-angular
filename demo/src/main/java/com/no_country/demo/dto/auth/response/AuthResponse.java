package com.no_country.demo.dto.auth.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String email;
    private String message;
    private String jwt;
    private boolean status;
}
