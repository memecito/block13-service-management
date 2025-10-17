package es.nter.spring_cloud.presentation.dto.trip;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public final class TripInDto {

    @NotBlank(message = "origin required")
    private String origin;
    @NotBlank(message = "destination required")
    private String destination;
    @NotBlank(message = "departure time required")
    private LocalDateTime departureDate;
    @NotBlank(message = "arrival time required")
    private LocalDateTime arrivalDate;
}
