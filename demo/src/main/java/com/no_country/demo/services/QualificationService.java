package com.no_country.demo.services;

import com.no_country.demo.dto.evaluation.QualificationDTO;
import com.no_country.demo.entities.Qualification;
import com.no_country.demo.repository.QualificationRepository;
import com.no_country.demo.util.mapper.QualificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    @Autowired
    private QualificationMapper qualificationMapper;

    public Qualification createQualification(QualificationDTO qualificationDTO) {
        return qualificationRepository.save(qualificationMapper.toEntity(qualificationDTO));
    }

    public List<QualificationDTO> getQualificationsByEvaluation(Long evaluationId) {
        return qualificationRepository.findByEvaluation_Id(evaluationId).stream()
                .map(qualificationMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteQualification(Long id) {
        qualificationRepository.deleteById(id);
    }
}
