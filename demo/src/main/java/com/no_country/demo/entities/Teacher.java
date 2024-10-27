package com.no_country.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends UserEntity {
    @OneToOne(cascade = CascadeType.ALL)
    private File file;
    @OneToMany(mappedBy="teacher")
    @JsonManagedReference  //para evitar recursion
    private List<Subject> subjects;
}
