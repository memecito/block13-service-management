package es.nter.spring_cloud.application.services.impl;

import es.nter.spring_cloud.application.services.TripService;
import es.nter.spring_cloud.persistence.entities.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
    @Override
    public Page<Trip> getAll(int page, int size) {
        return null;
    }

    @Override
    public Trip getById(Long id) {
        return null;
    }

    @Override
    public Trip created(Trip trip) {
        return null;
    }

    @Override
    public Trip updated(Long id, Trip trip) {
        return null;
    }

    @Override
    public void deleted(Long id) {

    }
}
