package com.no_country.demo.repository;

import com.no_country.demo.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositorylog extends JpaRepository<Teacher,Long> {
}
