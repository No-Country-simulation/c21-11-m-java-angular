package com.no_country.demo.dto.auth;

import com.no_country.demo.entities.*;
import lombok.Data;

import java.util.Date;

@Data
public class StudentRegisterRequest {
    private String name;
    private String lastname;
    private String password;
    private String email;
    private Locality locality;
    private Dni dni;
    private Adress address;
    private Date birthdate;
    private Phone phone;
    private File file;
}
