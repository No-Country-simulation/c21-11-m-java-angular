package com.no_country.demo.util.mapper;

import com.no_country.demo.dto.evaluation.QualificationDTO;
import com.no_country.demo.entities.Qualification;
import com.no_country.demo.entities.Student; // Asegúrate de importar la clase Student
import com.no_country.demo.entities.Evaluation; // Asegúrate de importar la clase Evaluation
import com.no_country.demo.repository.EvaluationRepository;
import com.no_country.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class QualificationMapper {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;

    public Qualification toEntity(QualificationDTO qualificationDTO) {
        Qualification qualification = new Qualification();
        qualification.setId(qualificationDTO.id());

        // Buscar el estudiante por ID
        if (qualificationDTO.studentId() != null) {
            Student student = studentRepository.findById(qualificationDTO.studentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            qualification.setStudent(student);
        }

        // Buscar la evaluación por ID
        if (qualificationDTO.evaluationId() != null) {
            Evaluation evaluation = evaluationRepository.findById(qualificationDTO.evaluationId())
                    .orElseThrow(() -> new RuntimeException("Evaluation not found"));
            qualification.setEvaluation(evaluation);
        }

        qualification.setNote(qualificationDTO.note());
        qualification.setComentario(qualificationDTO.comentario());

        return qualification;
    }

    public QualificationDTO toDto(Qualification qualification) {
        String studentName = qualification.getStudent() != null ? qualification.getStudent().getLastname()
                + " " + qualification.getStudent().getName(): null;

        String evaluationDate = qualification.getEvaluation() != null ?
                new SimpleDateFormat("yyyy-MM-dd").format(qualification.getEvaluation().getDateEvaluation()) : null;

        String subjectName = qualification.getEvaluation() != null && qualification.getEvaluation().getSubject() != null ?
                qualification.getEvaluation().getSubject().getSubject() : null;

        return new QualificationDTO(
                qualification.getId(),
                qualification.getStudent() != null ? qualification.getStudent().getId() : null,
                studentName, // Obtener el nombre del estudiante
                qualification.getEvaluation() != null ? qualification.getEvaluation().getId() : null,
                evaluationDate, // Obtener la fecha de la evaluación
                subjectName, // Obtener el nombre de la asignatura
                qualification.getNote(),
                qualification.getComentario()
        );
    }
}
