package com.no_country.demo.entities;

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
public class Student extends UserEntity {
    private Boolean statusStudent;
    private Date dateRegistrationCourse;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course currentCourse;

    @OneToMany(mappedBy = "student")
    private List<Evaluation> evaluations;

    @ManyToOne()
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;
}
