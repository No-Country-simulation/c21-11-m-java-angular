package com.no_country.demo.repository;

import com.no_country.demo.entities.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> findByEvaluation_Id(Long evaluationId);
    // Método para encontrar calificaciones por ID de evaluación
}
