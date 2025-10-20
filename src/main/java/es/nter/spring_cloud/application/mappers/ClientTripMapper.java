package es.nter.spring_cloud.application.mappers;

import es.nter.spring_cloud.persistence.entities.ClientTrip;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDtoMini;
import es.nter.spring_cloud.presentation.dto.clienttrip.ClientTripOutDto;
import es.nter.spring_cloud.presentation.dto.trip.TripOutDtoMini;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientTripMapper {

    @Mapping(target = "trip", source = "trip")
    @Mapping(target = "client", source = "client")
    ClientTripOutDto toDto(ClientTrip clientTrip);


    @Mapping(target = "id", source = "client.id")
    @Mapping(target = "email", source = "client.email")
    @Mapping(target = "phone", source = "client.phone")
    ClientOutDtoMini toClient(ClientTrip clientTrip);

    @Mapping(target = "origin", source = "trip.origin")
    @Mapping(target = "destination", source = "trip.destination")
    @Mapping(target = "departureDate", source = "trip.departureDate")
    @Mapping(target = "arrivalDate", source = "trip.arrivalDate")
    @Mapping(target = "status", source = "trip.status")
    TripOutDtoMini toTrip(ClientTrip clientTrip);


}
