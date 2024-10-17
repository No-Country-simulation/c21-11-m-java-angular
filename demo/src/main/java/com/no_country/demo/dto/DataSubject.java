package com.no_country.demo.dto;

import com.no_country.demo.entities.Evaluation;
import com.no_country.demo.entities.Teacher;
import com.no_country.demo.entities.enums.DayWeek;

import java.util.Date;
import java.util.List;

public record DataSubject(String name,  String topics, String description, Date schedule, List<DayWeek> days, List<Evaluation> evaluation) {
}
