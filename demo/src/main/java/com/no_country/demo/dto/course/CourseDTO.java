package com.no_country.demo.dto.course;

import com.no_country.demo.dto.subject.ListSubjectDTO;

import java.util.List;

public record CourseDTO(Long id, String nameCourse, String detailCourse, List<ListSubjectDTO> subjects,
                        List<String> studentIds) {

}
