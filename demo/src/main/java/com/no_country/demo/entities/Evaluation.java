package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.Qualification;
import com.no_country.demo.entities.enums.TypeEvaluation;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evaluation {
    private Student student;
    private TypeEvaluation typeEvaluation;
    private Subject subject;
    private Date dateEvaluation;
    private String topicsEvaluation;
    private Qualification qualification;
    private String comentario;
}
