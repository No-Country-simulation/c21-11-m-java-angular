package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//para mostrar en una sola tabla userEntity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String password;
    @ManyToOne(cascade = CascadeType.ALL)
    private Locality locality;
    @OneToOne(cascade = CascadeType.ALL)
    private Dni dni;
    @ManyToOne(cascade = CascadeType.ALL)
    private Adress address;
    private String email;
    private Date birthdate;
    @OneToOne(cascade = CascadeType.ALL)
    private Phone phone;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @Enumerated(EnumType.STRING)
    private UserState userState;
}
