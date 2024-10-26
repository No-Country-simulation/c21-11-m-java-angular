package com.no_country.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.no_country.demo.dto.DataSubject;
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
    @JsonManagedReference  //para evitar recursion
    @OneToMany(mappedBy = "subject")
    private List<Evaluation> evaluations;
    @ManyToMany(mappedBy = "subjects")
    private List<Course> courses;

    public Subject(DataSubject dataSubject){
        subject = dataSubject.name();
        topics = dataSubject.topics();
        description = dataSubject.description();
        schedule = dataSubject.schedule();
        days = dataSubject.days();
        evaluations = dataSubject.evaluation();
    }
    // Constructor que acepta solo el ID
    public Subject(Long id) {
        this.id = id;
    }
}
