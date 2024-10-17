package com.no_country.demo.repository;

import com.no_country.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositorylog extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);
}
