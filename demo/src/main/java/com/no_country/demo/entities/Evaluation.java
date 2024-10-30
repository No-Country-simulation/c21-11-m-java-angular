package com.no_country.demo.entities;

//import com.no_country.demo.entities.Qualification;
//import com.no_country.demo.entities.enums.TypeEvaluation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Evaluation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    //@ManyToOne
    //@JoinColumn(name = "id_student")
    //private Student student;
    //@Enumerated(EnumType.STRING)
    //private TypeEvaluation typeEvaluation;
    @ManyToOne
    @JoinColumn(name = "id_subject", nullable = false)
    @JsonBackReference  //para evitar recursion
    private Subject subject;
    @Temporal(TemporalType.DATE) //almacena la parte de la fecha (año,mes,dia)
    private Date dateEvaluation;
    private String topicsEvaluation;
    boolean isActive;
//    // AGREGAR RELACION CON CALIFICACION
//    @OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL)
//    private List<Qualification> qualifications;

//    @Enumerated(EnumType.ORDINAL)
//    private QualificationNote note;
    private String comentario;
}
