package com.no_country.demo.dto.course;

import java.util.List;

public record CourseDTO(Long id, String nameCourse, String detailCourse, List<String> subjectIds,
                        List<String> studentIds) {

}
