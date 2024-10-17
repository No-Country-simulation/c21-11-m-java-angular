package com.no_country.demo.dto;

import com.no_country.demo.entities.enums.DayWeek;

import java.util.List;

public record DataResponseSubject(Long id, String name,  List<DayWeek> days) {
}
