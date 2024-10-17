package com.no_country.demo.util.mapper;

import com.no_country.demo.dto.student.CreateStudentDTO;
import com.no_country.demo.dto.student.GetStudentDTO;
import com.no_country.demo.dto.student.UpdateStudentDTO;
import com.no_country.demo.entities.*;
import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student dtoToStudent(CreateStudentDTO createStudentDTO) {
        return Student.builder()
                .name(createStudentDTO.name())
                .lastname(createStudentDTO.lastname())
                .locality(Locality.builder().build())
                .password(createStudentDTO.dni())
                .dni(Dni.builder()
                        .dni(createStudentDTO.dni())
                        .build())
                .address(Adress.builder().build())
                .email(Email.builder()
                        .email(createStudentDTO.email())
                        .build())
                .birthdate(createStudentDTO.birthdate())
                .phone(Phone.builder().build())
                .rol(Rol.fromString(createStudentDTO.rol()))
                .userState(UserState.ACTIVE)
                .currentCourse(Course.builder().build())
                .tutor(Tutor.builder().build())
                .build();
    }

    //    el parametro de estudet se recupera del placeholder al autenticarse el mismo
    public void dtoToStudent(UpdateStudentDTO updateStudentDTO, Student student) {
        student.setName(updateStudentDTO.name() != null ? updateStudentDTO.name() : student.getName());
        student.setLastname(updateStudentDTO.lastname() != null ? updateStudentDTO.lastname() : student.getLastname());
        student.getLocality().setLocality(updateStudentDTO.locality() != null ? updateStudentDTO.locality() : student.getLocality().getLocality());
        student.setPassword(updateStudentDTO.password() != null ? updateStudentDTO.password() : student.getPassword());
        student.getDni().setDni(updateStudentDTO.dni() != null ? updateStudentDTO.dni() : student.getDni().getDni());
        student.getAddress().setAddress(updateStudentDTO.address() != null ? updateStudentDTO.address() : student.getAddress().getAddress());
        student.getEmail().setEmail(updateStudentDTO.email() != null ? updateStudentDTO.email() : student.getEmail().getEmail());
        student.setBirthdate(updateStudentDTO.birthdate() != null ? updateStudentDTO.birthdate() : student.getBirthdate());
        student.getPhone().setPhone(updateStudentDTO.phone() != null ? updateStudentDTO.phone() : student.getPhone().getPhone());
        student.setRol(Rol.fromString(updateStudentDTO.rol() != null ? updateStudentDTO.rol() : student.getRol().toString()));
        student.setUserState(updateStudentDTO.userState() != null ? UserState.valueOf(updateStudentDTO.userState().toUpperCase()) : student.getUserState());
        student.getCurrentCourse().setCourse(updateStudentDTO.currentCourse() != null ? updateStudentDTO.currentCourse() : student.getCurrentCourse().getCourse());
        student.getTutor().setName(updateStudentDTO.tutor() != null ? updateStudentDTO.tutor() : student.getTutor().getName());
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
                .email(student.getEmail().getEmail())
                .birthdate(student.getBirthdate())
                .phone(student.getPhone().getPhone())
                .rol(student.getRol().toString())
                .userState(student.getUserState().toString())
                .currentCourse(student.getCurrentCourse().getCourse())
                .tutor(student.getTutor().getName())
                .build();
    }
//    public void dtoToStudent(UpdateStudentDTO updateStudentDTO, Student student) {
//       student.builder()
//               .name(updateStudentDTO.name() != null ? updateStudentDTO.name() : student.getName())
//               .lastname(updateStudentDTO.lastname()!= null ? updateStudentDTO.lastname() : student.getLastname())
//               .locality(updateStudentDTO.locality() != null ? updateStudentDTO.locality(): student.getLocality())
//               .password(updateStudentDTO.password() != null ? updateStudentDTO.password() : student.getPassword())
//               .dni(Dni.builder()
//                       .dni(updateStudentDTO.dni() != null ? updateStudentDTO.dni() : student.getDni().getDni())
//                       .build())
//               .address(Adress.builder()
//                       .address(updateStudentDTO.address() != null ? updateStudentDTO.address() : student.getAddress().getAddress())
//                       .build())
//               .email(Email.builder()
//                       .email(updateStudentDTO.email() != null ? updateStudentDTO.email() : student.getEmail().getEmail())
//                       .build())
//               .birthdate(updateStudentDTO.birthdate() != null ? updateStudentDTO.birthdate() : student.getBirthdate())
//               .phone(Phone.builder()
//                       .phone(updateStudentDTO.phone() != null ? updateStudentDTO.phone():student.getPhone().getPhone())
//                       .build())
//               .rol(Rol.fromString(updateStudentDTO.rol() != null ? updateStudentDTO.rol() : student.getRol().toString()))
//               .userState(updateStudentDTO.userState() != null ? UserState.valueOf(updateStudentDTO.userState().toUpperCase()) : student.getUserState())
//               .currentCourse(Course.builder()
//                       .course(updateStudentDTO.currentCourse() != null ? updateStudentDTO.currentCourse() : student.getCurrentCourse().getCourse())
//                       .build())
//               .tutor(Tutor.builder()
//                       .name(updateStudentDTO.tutor() != null ? updateStudentDTO.tutor() : student.getTutor().getName())
//                       .build())
//               .build();
//    }
}
