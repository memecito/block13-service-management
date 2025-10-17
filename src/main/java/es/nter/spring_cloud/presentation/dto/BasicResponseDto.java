package es.nter.spring_cloud.presentation.dto;

import lombok.Builder;

@Builder
public record BasicResponseDto(
        int status,
        String message
) {
}
