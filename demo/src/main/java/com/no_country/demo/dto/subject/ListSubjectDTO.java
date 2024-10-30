package com.no_country.demo.dto.subject;

import lombok.Builder;

@Builder
public record ListSubjectDTO(
        Long id,
        String subject,
        String topic
) {
}
