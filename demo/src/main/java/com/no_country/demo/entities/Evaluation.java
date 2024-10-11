package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.Qualification;
import com.no_country.demo.entities.enums.TypeEvaluation;
import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
//    private Student student; en el diagrama no estan relacionados
    @Enumerated(EnumType.STRING)
    private TypeEvaluation typeEvaluation;
    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;
    private Date dateEvaluation;
    private String topicsEvaluation;
//    private Qualification qualification; no seria mejor long o un numero con decimales
    private String comentario;
}
