package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.Rol;
import com.no_country.demo.entities.enums.UserState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private String name;
    private String lastname;
    private String password;
    private Dni dni;
    private Adress adress;
    private Email email;
    private Date birthdate;
    private Phone phone;
    private Rol rol;
    private UserState userState;

}
