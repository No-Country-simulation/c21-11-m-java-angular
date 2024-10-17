package com.no_country.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
public class Tutor extends UserEntity {

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Student> students;
    private String detail;
}
