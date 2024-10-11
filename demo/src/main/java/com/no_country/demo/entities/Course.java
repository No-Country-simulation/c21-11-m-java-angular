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
//    tengo dudas sobre la relacion con subject
//    private List<Subject> subjects;
    private String detail;
    @OneToMany(mappedBy = "currentCourse", cascade = CascadeType.ALL)
    private List<Student> students;
}
