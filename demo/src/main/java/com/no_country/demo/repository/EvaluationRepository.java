package com.no_country.demo.repository;

import com.no_country.demo.entities.Course;
import com.no_country.demo.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    // Lista de evaluaciones por asignatura
    List<Evaluation> findBySubject_Id(Long subjectId);
}
