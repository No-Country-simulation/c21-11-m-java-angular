package com.no_country.demo.repository;

import com.no_country.demo.entities.Subject;
import com.no_country.demo.entities.enums.DayWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
