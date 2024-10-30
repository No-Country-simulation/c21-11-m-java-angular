package com.no_country.demo.util.mapper;

import com.no_country.demo.dto.user.ListUserDTO;
import com.no_country.demo.dto.user.UpdateUserDTO;
import com.no_country.demo.entities.Student;
import com.no_country.demo.entities.Teacher;
import com.no_country.demo.entities.UserEntity;
import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public void dtoToUser(UpdateUserDTO updateUserDTO, UserEntity userEntity) {
        userEntity.setName(updateUserDTO.name() != null ? updateUserDTO.name() : userEntity.getName());
        userEntity.setLastname(updateUserDTO.lastname() != null ? updateUserDTO.lastname() : userEntity.getLastname());
        userEntity.getLocality().setLocality(updateUserDTO.locality() != null ? updateUserDTO.locality() : userEntity.getLocality().getLocality());
        userEntity.setPassword(updateUserDTO.password() != null ? updateUserDTO.password() : userEntity.getPassword());
        userEntity.getDni().setDni(updateUserDTO.dni() != null ? updateUserDTO.dni() : userEntity.getDni().getDni());
        userEntity.getAddress().setAddress(updateUserDTO.address() != null ? updateUserDTO.address() : userEntity.getAddress().getAddress());
        userEntity.setEmail(updateUserDTO.email() != null ? updateUserDTO.email() : userEntity.getEmail());
        userEntity.setBirthdate(updateUserDTO.birthdate() != null ? updateUserDTO.birthdate() : userEntity.getBirthdate());
        userEntity.getPhone().setPhone(updateUserDTO.phone() != null ? updateUserDTO.phone() : userEntity.getPhone().getPhone());
        userEntity.setRol(Rol.fromString(updateUserDTO.rol() != null ? updateUserDTO.rol() : userEntity.getRol().toString()));
        userEntity.setUserState(updateUserDTO.userState() != null ? UserState.valueOf(updateUserDTO.userState().toUpperCase()) : userEntity.getUserState());
        if (userEntity instanceof Teacher teacher) {
            teacher.getFile().setFile(updateUserDTO.file() != null ? updateUserDTO.file() : teacher.getFile().getFile());
        } else if (userEntity instanceof Student student) {
//            student.getCurrentCourse().setCourse(updateUserDTO.currentCourse() != null ? updateUserDTO.currentCourse() : student.getCurrentCourse().getCourse());
//            student.getTutor().setName(updateUserDTO.tutor() != null ? updateUserDTO.tutor() : student.getTutor().getName());
        }
    }

    public ListUserDTO toListUserDTO(UserEntity userEntity) {
        return ListUserDTO.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .lastname(userEntity.getLastname())
                .rol(userEntity.getRol())
                .userState(userEntity.getUserState())
                .build();
    }
}
