package es.nter.spring_cloud.application.mappers;

import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.presentation.dto.client.ClientInDto;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDto;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDtoMini;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",
uses = {ClientTripMapper.class})
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true, defaultValue = "true")
    Client toModel(ClientInDto clientInDto);

    @Mapping(target = "trips", source = "trips")
    ClientOutDto toDto(Client client);

    ClientOutDtoMini toDtoMini(Client client);

    @Mapping(target = "id", ignore = true)
    Client toUpdate(@MappingTarget Client target, Client source);
}
