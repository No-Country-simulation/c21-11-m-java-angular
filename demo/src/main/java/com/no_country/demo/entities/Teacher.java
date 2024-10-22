package com.no_country.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Teacher extends UserEntity {
    @OneToOne(cascade = CascadeType.ALL)
    private File file;
    @OneToMany(mappedBy="teacher")
    private List<Subject> subjects;
}
