package com.no_country.demo.util.mapper;

import com.no_country.demo.dto.user.CreateUserDTO;
import com.no_country.demo.dto.user.teacher.GetTeachertDTO;
import com.no_country.demo.entities.*;
import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import org.springframework.stereotype.Service;

@Service
public class TeacherMapper {
    public Teacher dtoToTeacher(CreateUserDTO createUserDTO) {
        return Teacher.builder()
                .name(createUserDTO.name())
                .lastname(createUserDTO.lastname())
                .locality(Locality.builder().build())
                .password(createUserDTO.dni())
                .dni(Dni.builder()
                        .dni(createUserDTO.dni())
                        .build())
                .address(Adress.builder().build())
                .email(createUserDTO.email())
                .birthdate(createUserDTO.birthdate())
                .phone(Phone.builder().build())
                .rol(Rol.fromString(createUserDTO.rol()))
                .userState(UserState.ACTIVE)
                .file(File.builder()
                        .file(createUserDTO.file())
                        .build())
                .build();
    }
    public GetTeachertDTO teacherToDto(Teacher teacher) {
        return GetTeachertDTO.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .lastname(teacher.getLastname())
                .password(teacher.getPassword())
                .locality(teacher.getLocality().getLocality())
                .dni(teacher.getDni().getDni())
                .address(teacher.getAddress().getAddress())
                .email(teacher.getEmail())
                .birthdate(teacher.getBirthdate())
                .phone(teacher.getPhone().getPhone())
                .rol(teacher.getRol().toString())
                .userState(teacher.getUserState().toString())
                .file(teacher.getFile().getFile())
//                falt
//                .subjects(
//                        teacher.getSubjects()
//                               .stream()
//                               .map(Subject::getSubject)
//                               .collect(Collectors.toList())
//                )
                .build();
    }
}
