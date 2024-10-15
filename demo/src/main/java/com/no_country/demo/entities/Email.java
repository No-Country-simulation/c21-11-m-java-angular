package com.no_country.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    @OneToOne(mappedBy="email", cascade = CascadeType.ALL)
    private UserEntity user;

    public Email(String email) {
        this.email = email;
    }
}
