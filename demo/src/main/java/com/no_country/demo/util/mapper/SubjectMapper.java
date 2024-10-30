package com.no_country.demo.util.mapper;

import com.no_country.demo.dto.subject.GetSubjectDTO;
import com.no_country.demo.dto.subject.ListSubjectDTO;
import com.no_country.demo.entities.Course;
import com.no_country.demo.entities.Evaluation;
import com.no_country.demo.entities.Subject;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class SubjectMapper {
    public GetSubjectDTO toDTO(Subject subject) {
        return GetSubjectDTO.builder()
                .id(subject.getId())
                .subject(subject.getSubject())
                .teacherId(subject.getTeacher() != null ? subject.getTeacher().getId() : null)
                .topics(subject.getTopics())
                .description(subject.getDescription())
                .schedule(subject.getSchedule())
                .days(subject.getDays())
                .evaluationIds(subject.getEvaluations() != null ? subject.getEvaluations().stream().map(Evaluation::getId).collect(Collectors.toList()) : Collections.emptyList())
                .courseIds(subject.getCourses() != null ? subject.getCourses().stream().map(Course::getId).collect(Collectors.toList()) : Collections.emptyList())
                .build();
    }

    public ListSubjectDTO toListDTO(Subject subject) {
        return ListSubjectDTO.builder()
                .id(subject.getId())
                .subject(subject.getSubject())
                .topic(subject.getTopics())
                .build();
        }
    }

