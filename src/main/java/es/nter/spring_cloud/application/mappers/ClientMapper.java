package es.nter.spring_cloud.application.mappers;

import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.presentation.dto.client.ClientInDto;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toModel(ClientInDto clientInDto);

    ClientOutDto toDto(Client client);

    Client toUpdate(Client target, Client source);
}
