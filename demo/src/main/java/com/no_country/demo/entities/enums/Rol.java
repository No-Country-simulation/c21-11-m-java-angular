package com.no_country.demo.entities.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Rol {
    STUDENT("student"),
    ADMINISTRATOR("admin"),
    TUTOR("tutor"),
    TEACHER("teacher"),
    ATTENDANT("attendant");

    private final String rolAsignment;
    public static Rol fromString(String text) {
//        agregar excepciones personalizadas
        for (Rol r : Rol.values()) {
            if (r.rolAsignment.equalsIgnoreCase(text)) {
                return r;
            }
        }
        throw new IllegalArgumentException("ningun rol fuen encontrado:"+ text);
    }
}