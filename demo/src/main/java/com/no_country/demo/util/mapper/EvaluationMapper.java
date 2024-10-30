package com.no_country.demo.util.mapper;
import com.no_country.demo.dto.evaluation.EvaluationDTO;
import com.no_country.demo.dto.evaluation.GetEvaluationDTO;
import com.no_country.demo.dto.evaluation.ListEvaluationDTO;
import com.no_country.demo.dto.evaluation.UpdateEvaluationDTO;
import com.no_country.demo.entities.Evaluation;
import com.no_country.demo.entities.Subject;
import com.no_country.demo.repository.SubjectRepository;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EvaluationMapper {


    private SubjectRepository subjectRepository; // Inyecta tu repositorio de Subject
    private SubjectMapper subjectMapper;
    public Evaluation toEntity(EvaluationDTO evaluationDTO) {
        Evaluation evaluation = new Evaluation();
        evaluation.setId(evaluationDTO.id());
        evaluation.setDateEvaluation(evaluationDTO.dateEvaluation());
        evaluation.setTopicsEvaluation(evaluationDTO.topicsEvaluation());
        evaluation.setComentario(evaluationDTO.comentario());
        evaluation.setActive(evaluationDTO.isActive());

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
                evaluation.getDateEvaluation(),
                evaluation.getTopicsEvaluation(),
                evaluation.getComentario(),
                evaluation.isActive()
        );
    }
    public GetEvaluationDTO toGetDto(Evaluation evaluation) {
        return GetEvaluationDTO.builder()
                .id(evaluation.getId())
                .dateEvaluation(evaluation.getDateEvaluation())
                .topicsEvaluation(evaluation.getTopicsEvaluation())
                .comentario(evaluation.getComentario())
                .subject(subjectMapper.toListDTO(evaluation.getSubject()))
                .isActive(evaluation.isActive())
                .build();
    }

    public void toUpdate(Evaluation evaluation, UpdateEvaluationDTO update) {
        evaluation.setDateEvaluation(update.dateEvaluation()!=null ? update.dateEvaluation():evaluation.getDateEvaluation());
        evaluation.setTopicsEvaluation(update.topicsEvaluation()!=null ? update.topicsEvaluation():evaluation.getTopicsEvaluation());
        evaluation.setComentario(update.comentario()!=null ? update.comentario():evaluation.getComentario());

        // Update the subject if the ID is provided
        if (update.subjectID() != null) {
            Subject subject = subjectRepository.findById(update.subjectID())
                    .orElseThrow(() -> new RuntimeException("Subject not found"));
            evaluation.setSubject(subject);
        }
    }

    public ListEvaluationDTO toListDto(Evaluation evaluation) {
        return ListEvaluationDTO.builder()
               .id(evaluation.getId())
               .dateEvaluation(evaluation.getDateEvaluation())
               .topicsEvaluation(evaluation.getTopicsEvaluation())
               .comentario(evaluation.getComentario())
               .subjectId(evaluation.getSubject().getId())
               .build();
    }
}