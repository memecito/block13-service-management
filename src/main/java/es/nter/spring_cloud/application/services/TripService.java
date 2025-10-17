package es.nter.spring_cloud.application.services;

import es.nter.spring_cloud.persistence.entities.Trip;
import org.springframework.data.domain.Page;

public interface TripService {
    Page<Trip> getAll(int page, int size);
    Trip getById(Long id);
    Trip created(Trip trip);
    Trip updated(Long id, Trip trip);
    void deleted (Long id);
}
