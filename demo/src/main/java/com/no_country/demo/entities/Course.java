package com.no_country.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id")
    )
    private List<Subject> subjects;


    @OneToMany(mappedBy = "currentCourse", cascade = CascadeType.ALL)
    private List<Student> students;
}
