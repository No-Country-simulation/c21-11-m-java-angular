package com.no_country.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.Date;
import java.util.List;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student extends UserEntity {
    private Date dateRegistrationCourse;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course currentCourse;

//    @OneToMany(mappedBy = "student")
//    private List<Evaluation> evaluations; // Cambia a Qualification

@OneToMany(mappedBy = "student") // Esta relación se mantiene
@JsonManagedReference  //para evitar recursion
private List<Qualification> qualifications; // Cambia a Qualification

    @ManyToOne(cascade = CascadeType.ALL)
    private Tutor tutor;
}
