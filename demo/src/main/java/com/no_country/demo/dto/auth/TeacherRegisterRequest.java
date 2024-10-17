package com.no_country.demo.dto.auth;

import com.no_country.demo.entities.*;
import lombok.Data;

import java.util.Date;

@Data
public class TeacherRegisterRequest {
    private String name;
    private String lastname;
    private String password;
    private String email;
    private Locality locality;
    private Dni dni;
    private Adress address;
    private Date birthdate;
    private Phone phone;
    private Date dateRegistrationCourse;
    private Course currentCourse;
    private Tutor tutor;
}
