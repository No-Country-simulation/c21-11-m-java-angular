package com.no_country.demo.services;
import com.no_country.demo.dto.evaluation.EvaluationDTO;
import com.no_country.demo.entities.Evaluation;
import com.no_country.demo.entities.Subject;
import com.no_country.demo.repository.EvaluationRepository;
import com.no_country.demo.repository.SubjectRepository;
import com.no_country.demo.util.mapper.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private SubjectRepository subjectRepository; // para buscar la asignatura

    @Autowired
    private EvaluationMapper evaluationMapper;

    public Evaluation createEvaluation(EvaluationDTO evaluationDTO) {
        return evaluationRepository.save(evaluationMapper.toEntity(evaluationDTO));
    }
    //Lista todas las evaluaciones
    public List<EvaluationDTO> getAllEvaluations() {
        return evaluationRepository.findAll().stream()
                .map(evaluationMapper::toDto)
                .collect(Collectors.toList());
    }
    // Lista evaluaciones por asignatura
    public List<EvaluationDTO> getEvaluationsBySubject(Long subjectId) {
        return evaluationRepository.findBySubject_Id(subjectId).stream()
                .map(evaluationMapper::toDto)
                .collect(Collectors.toList());
    }

    public EvaluationDTO getEvaluationById(Long id) {
        return evaluationMapper.toDto(evaluationRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Evaluation not found")) );
    }
}


