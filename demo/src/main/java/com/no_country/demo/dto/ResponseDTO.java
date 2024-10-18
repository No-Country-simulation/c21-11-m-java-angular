package com.no_country.demo.dto;

public record ResponseDTO(
        Boolean success,
        String message,
        Object data
) {
}
