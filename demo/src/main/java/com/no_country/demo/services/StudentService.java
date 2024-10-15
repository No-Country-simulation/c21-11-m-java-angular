package com.no_country.demo.services;

import com.no_country.demo.dto.student.CreateStudentDTO;
import com.no_country.demo.dto.student.UpdateStudentDTO;
import com.no_country.demo.entities.Student;
import com.no_country.demo.entities.enums.UserState;
import com.no_country.demo.repository.StudentRepository;
import com.no_country.demo.util.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    // Create
    public Student createStudent(CreateStudentDTO createStudentDTO) {
        Student newStudent=studentMapper.dtoToStudent(createStudentDTO);
        return studentRepository.save(newStudent);
    }

    // Read All
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Read By ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update
    public Student updateStudent(Long id,UpdateStudentDTO updateStudentDTO) {
        Student student = getStudentById(id);

    }

    // Delete
    public void deleteStudent(Long id) {
        getStudentById(id).setUserState(UserState.INACTIVE);
    }
}
