package com.no_country.demo.services;

import com.no_country.demo.dto.user.student.GetStudentDTO;
import com.no_country.demo.entities.Student;
import com.no_country.demo.entities.enums.UserState;
import com.no_country.demo.repository.StudentRepository;
import com.no_country.demo.util.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    // Read All
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public GetStudentDTO getStudentDTO(Long id) {
        return studentMapper.studentToDto(getStudentById(id));
    }
    // Read By ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Delete
//    public void deleteStudent(Long id) {
//        getStudentById(id).setUserState(UserState.INACTIVE);
//    }
}
