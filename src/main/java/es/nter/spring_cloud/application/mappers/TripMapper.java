package es.nter.spring_cloud.application.mappers;

import es.nter.spring_cloud.persistence.entities.Trip;
import es.nter.spring_cloud.presentation.dto.trip.TripInDto;
import es.nter.spring_cloud.presentation.dto.trip.TripOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripMapper {

    Trip toModel(TripInDto tripInDto);

    TripOutDto toDto(Trip trip);

    Trip toUpdate(Trip target, Trip source);
}
