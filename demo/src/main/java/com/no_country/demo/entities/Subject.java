package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.DiaSemana;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    private String subject;
    private Teacher teacher;
    private String topics;
    private String description;
    private List<Evaluacion> evaluations;
    private Date schedule;
    private List<DiaSemana> days;
}
