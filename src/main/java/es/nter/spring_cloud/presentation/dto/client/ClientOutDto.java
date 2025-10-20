package es.nter.spring_cloud.presentation.dto.client;


import es.nter.spring_cloud.presentation.dto.trip.TripOutDtoMini;

import java.util.Set;

public record ClientOutDto(
         long id,
         String name,
         String surname,
         int age,
         String email,
         String phone,
         Set<TripOutDtoMini> trips
) {
}
