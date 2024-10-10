package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.DayWeek;
import jakarta.persistence.*;
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
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
//  sugerencia de cambiar el nombre de las variablees que se refiene al nombre
//  de la clase a name por buena practica
    private String subject;
    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
    private String topics;
    private String description;
//    private List<Evaluacion> evaluations;
    private Date schedule;
    @Enumerated(EnumType.STRING)
    private List<DayWeek> days;
}
