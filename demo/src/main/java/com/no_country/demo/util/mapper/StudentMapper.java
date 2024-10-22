package com.no_country.demo.util.mapper;

import com.no_country.demo.dto.user.CreateUserDTO;
import com.no_country.demo.dto.user.student.GetStudentDTO;
import com.no_country.demo.entities.*;
import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student dtoToStudent(CreateUserDTO createUserDTO) {
//        Student newStudent =
        return Student.builder()
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
                .currentCourse(Course.builder().build())
                .tutor(Tutor.builder().build())
                .build();
    }

    public GetStudentDTO studentToDto(Student student) {
        return GetStudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .lastname(student.getLastname())
                .password(student.getPassword())
                .locality(student.getLocality().getLocality())
                .dni(student.getDni().getDni())
                .address(student.getAddress().getAddress())
                .email(student.getEmail())
                .birthdate(student.getBirthdate())
                .phone(student.getPhone().getPhone())
                .rol(student.getRol().toString())
                .userState(student.getUserState().toString())
                .currentCourse(student.getCurrentCourse().getCourse())
                .tutor(student.getTutor().getName())
                .build();
    }

}
