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
public class Tutor extends UserEntity {

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Student> students;
    private String detail;
}
