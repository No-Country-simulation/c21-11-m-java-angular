package com.no_country.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dni {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int dni;
    @OneToOne(mappedBy="dni", cascade = CascadeType.ALL)
    private UserEntity user;

    public Dni(Integer dni) {
        this.dni = dni;
    }
}
