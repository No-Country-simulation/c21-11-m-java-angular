package com.no_country.demo.util.mapper;

import com.no_country.demo.dto.student.CreateStudentDTO;
import com.no_country.demo.entities.Dni;
import com.no_country.demo.entities.Email;
import com.no_country.demo.entities.Student;
import com.no_country.demo.entities.enums.Rol;

//@Service
public class StudentMapper {
    public Student dtoToStudent(CreateStudentDTO createStudentDTO) {
        return Student.builder()
                .name(createStudentDTO.name())
                .lastname(createStudentDTO.lastname())
                .password(createStudentDTO.password())
                .dni(new Dni(createStudentDTO.dni()))
                .email(new Email(createStudentDTO.email()))
                .birthdate(createStudentDTO.birthdate())
                .rol(Rol.fromString(createStudentDTO.rol()))
                .build();
    }
}
