package com.no_country.demo.repository;

import com.no_country.demo.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepositorylog extends JpaRepository<Email,Long> {
}
