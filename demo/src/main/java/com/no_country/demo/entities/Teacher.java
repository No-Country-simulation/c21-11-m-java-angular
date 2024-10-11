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
public class Teacher extends UserEntity {
    @OneToOne
    @JoinColumn(name="id_file")
    private File file;
    @OneToMany(mappedBy="teacher", cascade = CascadeType.ALL)
    private List<Subject> subjects;
}
