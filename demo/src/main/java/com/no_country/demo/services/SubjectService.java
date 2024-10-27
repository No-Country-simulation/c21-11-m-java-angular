package com.no_country.demo.services;

import com.no_country.demo.entities.Subject;
import com.no_country.demo.entities.Teacher;
import com.no_country.demo.repository.SubjectRepository;
import com.no_country.demo.repository.TeacherRepository;
import com.no_country.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public void assignTeacherToSubject(Long subjectId, Long teacherId) {
        // Buscar la asignatura por su ID
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + subjectId));

        // Buscar el profesor por su ID
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + teacherId));

        // Asignar el profesor a la asignatura
        subject.setTeacher(teacher); // Asegúrate de tener este método en la clase Subject

        // Guardar los cambios en la base de datos
        subjectRepository.save(subject);
    }
}
