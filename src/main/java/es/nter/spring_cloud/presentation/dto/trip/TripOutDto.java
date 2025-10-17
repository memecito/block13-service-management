package es.nter.spring_cloud.presentation.dto.trip;

import java.time.LocalDateTime;

public record TripOutDto(
         long id,
         String origin,
         String destination,
         LocalDateTime departureDate,
         LocalDateTime arrivalDate,
         String status
) {
}
