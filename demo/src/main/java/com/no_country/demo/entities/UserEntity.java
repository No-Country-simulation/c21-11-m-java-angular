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
    @OneToOne(cascade = CascadeType.ALL)
    private Email email;
    private Date birthdate;
    @OneToOne(cascade = CascadeType.ALL)
    private Phone phone;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @Enumerated(EnumType.STRING)
    private UserState userState;

    @Column(name = "is_enable")
    private boolean isEnable;

    @Column(name = "account_no_expired")
    private boolean accountNoExpired;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @Column(name = "credential_no_expired")
    private boolean credentialNoExpired;
}
