package com.no_country.demo.entities;

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
public class Student extends UserEntity {
    private Boolean statusStudent;
    private Course currentCourse;
    private List<Evaluation> evaluations;
    private Date dateRegistrationCourse;
    private Tutor tutor;
}
