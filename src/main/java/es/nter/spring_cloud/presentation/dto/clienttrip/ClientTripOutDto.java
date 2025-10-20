package es.nter.spring_cloud.presentation.dto.clienttrip;

import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.persistence.entities.Trip;

public record ClientTripOutDto
        (
                Long id,
                Client client,
                Trip trip
        ){
}
