package es.nter.spring_cloud.presentation.dto.trip;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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
