package com.no_country.demo.util.mapper;
import com.no_country.demo.dto.evaluation.EvaluationDTO;
import com.no_country.demo.entities.Evaluation;
import com.no_country.demo.entities.Subject;
import com.no_country.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EvaluationMapper {

    @Autowired
    private SubjectRepository subjectRepository; // Inyecta tu repositorio de Subject

    public Evaluation toEntity(EvaluationDTO evaluationDTO) {
        Evaluation evaluation = new Evaluation();
        evaluation.setId(evaluationDTO.id());
        evaluation.setDateEvaluation(evaluationDTO.dateEvaluation());
        evaluation.setTopicsEvaluation(evaluationDTO.topicsEvaluation());
        evaluation.setComentario(evaluationDTO.comentario());

        // Establecer el subject utilizando el ID del DTO
        if (evaluationDTO.subjectId() != null) {
            Subject subject = subjectRepository.findById(evaluationDTO.subjectId())
                    .orElseThrow(() -> new RuntimeException("Subject not found"));
            evaluation.setSubject(subject);
        }

        return evaluation;
    }

    public EvaluationDTO toDto(Evaluation evaluation) {
        return new EvaluationDTO(
                evaluation.getId(),
                // Obtener el ID de la asignatura
                evaluation.getSubject() != null ?
                        evaluation.getSubject().getId() : null,
                // Obtener el nombre de la asignatura
                evaluation.getSubject() != null ?
                        evaluation.getSubject().getSubject() : null,
                evaluation.getDateEvaluation(),
                evaluation.getTopicsEvaluation(),
                evaluation.getComentario()
        );
    }
}