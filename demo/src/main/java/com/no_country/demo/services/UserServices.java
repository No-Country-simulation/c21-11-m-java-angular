package com.no_country.demo.services;

import com.no_country.demo.dto.user.CreateUserDTO;
import com.no_country.demo.dto.user.UpdateUserDTO;
import com.no_country.demo.entities.Student;
import com.no_country.demo.entities.Teacher;
import com.no_country.demo.entities.UserEntity;
import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.repository.UserRepository;
import com.no_country.demo.util.mapper.StudentMapper;
import com.no_country.demo.util.mapper.TeacherMapper;
import com.no_country.demo.util.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServices {
    private final UserRepository userRepository;
    private final TeacherMapper teacherMapper;
    private final StudentMapper studentMapper;
    private final UserMapper userMapper;

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity createUser(CreateUserDTO createUserDTO) {
        UserEntity user = createUserEntity(createUserDTO, Rol.fromString(createUserDTO.rol()));
        return userRepository.save(user);
    }

    private UserEntity createUserEntity(CreateUserDTO createUserDTO, Rol rol) {
        return switch (rol) {
            case STUDENT -> studentMapper.dtoToStudent(createUserDTO);
            case TEACHER -> teacherMapper.dtoToTeacher(createUserDTO);
            default -> throw new UnsupportedOperationException("Rol no soportado: " + rol);
        };
    }


    public Object userToDto(UserEntity user){
        if (user instanceof Student student){
            return ResponseEntity.ok(studentMapper.studentToDto(student));
        } else if (user instanceof Teacher teacher) {
            return ResponseEntity.ok(teacherMapper.teacherToDto(teacher));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }

    public void updateUserById(Long id, UpdateUserDTO updateUserDTO) {
        UserEntity user = getUserById(id);
        userMapper.dtoToUser(updateUserDTO,user);
    }
}
