package es.nter.spring_cloud.application.services;

import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.persistence.entities.Trip;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface TripService {
    Page<Trip> getAll(int page, int size);

    Trip getById(Long id);

    Set<Client> getPassenger(Long id);

    Trip created(Trip trip);

    Trip addPassenger(Long tripId, Long clientId);

    Trip updated(Long id, Trip trip);

    Trip updatedStatus(Long tripId, String newStatus);

    void deleted(Long id);

}
