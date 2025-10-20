package es.nter.spring_cloud.application.mappers;

import es.nter.spring_cloud.application.services.ClientService;
import es.nter.spring_cloud.persistence.entities.ClientTrip;
import es.nter.spring_cloud.persistence.entities.Trip;
import es.nter.spring_cloud.presentation.dto.trip.TripInDto;
import es.nter.spring_cloud.presentation.dto.trip.TripOutDto;
import es.nter.spring_cloud.presentation.dto.trip.TripOutDtoMini;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",
        uses = {   ClientTripMapper.class})
public interface TripMapper {

    @Mapping(target = "id", ignore = true)
    Trip toModel(TripInDto tripInDto);

    @Mapping(target = "passengers", source="clients")
    TripOutDto toDto(Trip trip);

    TripOutDtoMini toDtoMini(Trip trip);

    @Mapping(target = "id", ignore = true)
    Trip toUpdate(@MappingTarget Trip target, Trip source);
}
