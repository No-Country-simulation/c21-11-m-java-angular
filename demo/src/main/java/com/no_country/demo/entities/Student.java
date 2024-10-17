package com.no_country.demo.entities;

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

    @OneToMany(mappedBy = "student")
    private List<Evaluation> evaluations;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tutor tutor;
}
