package com.no_country.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String course;
    private String detail;
//    tengo dudas sobre la relacion con subject

    @ManyToMany()
    @JoinTable(
            name = "course_subject",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;  //materias asociadas al curso
    @OneToMany(mappedBy = "currentCourse", cascade = CascadeType.ALL)
    private List<Student> students;  //alumnos asociados al curso

}
