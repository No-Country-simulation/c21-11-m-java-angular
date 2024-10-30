package com.no_country.demo.dto.user;

import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record ListUserDTO(
        @Schema(description = "ID del usuario", example = "1")
        Long id,

        @Schema(description = "Nombre del usuario", example = "John")
        String name,

        @Schema(description = "Apellido del usuario", example = "Doe")
        String lastname,

        @Schema(description = "Correo electrónico del usuario", example = "johndoe@example.com")
        String email,

        @Schema(description = "Rol del usuario", example = "TEACHER")
        Rol rol,

        @Schema(description = "Estado del usuario", example = "ACTIVO")
        UserState userState
) {
}
