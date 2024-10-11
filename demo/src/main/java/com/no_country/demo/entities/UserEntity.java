package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//para mostrar en una sola tabla userEntity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String password;
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
