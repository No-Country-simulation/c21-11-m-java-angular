package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
//@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//para mostrar en una sola tabla userEntity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String password;
    private String locality;
    @OneToOne
    @JoinColumn(name="id_dni")
    private Dni dni;
    @ManyToOne
    @JoinColumn(name="id_address")
    private Adress address;
    @OneToOne
    @JoinColumn(name="id_email")
    private Email email;
    private Date birthdate;
    @OneToOne
    @JoinColumn(name="id_phone")
    private Phone phone;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @Enumerated(EnumType.STRING)
    private UserState userState;

}
