package com.no_country.demo.controller;

import com.no_country.demo.dto.ResponseDTO;
import com.no_country.demo.dto.user.CreateUserDTO;
import com.no_country.demo.dto.user.UpdateUserDTO;
import com.no_country.demo.dto.user.student.GetStudentDTO;
import com.no_country.demo.dto.user.teacher.GetTeachertDTO;
import com.no_country.demo.entities.UserEntity;
import com.no_country.demo.services.StudentService;
import com.no_country.demo.services.UserServices;
import com.no_country.demo.util.mapper.StudentMapper;
import com.no_country.demo.util.mapper.TeacherMapper;
import com.no_country.demo.util.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "User", description = "Controlador de Usuarios ")
public class UserController {
    UserServices userServices;
    StudentService studentService;
    UserMapper userMapper;
    StudentMapper studentMapper;
    TeacherMapper teacherMapper;


    @Operation(
            summary = "Crea un nuevo usuario",
            description = "Este endpoint permite crear un nuevo usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Profesor creado con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetTeachertDTO.class))),
            @ApiResponse(responseCode = "201",
                    description = "Estudiante creado con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetStudentDTO.class))),
    })
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        UserEntity user= userServices.createUser(createUserDTO);
        return ResponseEntity.ok(userServices.userToDto(user));
    }
    @Operation(
            summary = "Optener Usuario",
            description = "Este endpoint permite optener un usuario pasandole el ID del usuario por la ruta"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetStudentDTO.class))),
            @ApiResponse(responseCode = "201",
                    description = "Estudiante creado con éxito",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GetTeachertDTO.class))),
    })
//
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        UserEntity user = userServices.getUserById(id);
        return ResponseEntity.ok(userServices.userToDto(user));
    }

    @Operation(
            summary = "Actualizar Usuario",
            description = "Este endpoint permite actualizar un usuario"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class),
                            examples = @ExampleObject(value = "{ \"mensaje\": \"el usuario se actualizo correct\" }"))),
    })
    @Transactional
    @PatchMapping("/update/{id}")
    public ResponseEntity<Map<String,String>> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody UpdateUserDTO updateUserDTO) {
        userServices.updateUserById(id, updateUserDTO);
        return ResponseEntity.ok(Map.of("mensaje", "el usuario se actualizo correct"));
    }

@Operation(
        summary = "Obtener lista de usuarios",
        description = "Este endpoint permite obtener una lista de todos los usuarios"
)
@ApiResponses(value = {
        @ApiResponse(responseCode = "200",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = GetStudentDTO.class))),
})
@GetMapping("/list")
public ResponseEntity<ResponseDTO> getAllUsers() {
    List<UserEntity> users = userServices.getAllUsers()
            ;
    return ResponseEntity.ok(new ResponseDTO(
            true,
            "Lista de usuarios Exitosa",
            users.stream().map(userMapper::toListUserDTO).toList()
    ));
}

}
