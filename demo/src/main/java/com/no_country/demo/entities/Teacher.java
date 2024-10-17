package com.no_country.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
public class Teacher extends UserEntity {
    @OneToOne
    @JoinColumn(name="id_file")
    private File file;
    @OneToMany(mappedBy="teacher")
    private List<Subject> subjects;
}
