package es.nter.spring_cloud.presentation.dto.trip;

import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDtoMini;

import java.time.LocalDateTime;
import java.util.Set;

public record TripOutDto(
         long id,
         String origin,
         String destination,
         LocalDateTime departureDate,
         LocalDateTime arrivalDate,
         String status,
         Set<ClientOutDtoMini> passengers
) {
}
