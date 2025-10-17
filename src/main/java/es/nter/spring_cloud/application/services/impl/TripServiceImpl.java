package es.nter.spring_cloud.application.services.impl;

import es.nter.spring_cloud.application.mappers.TripMapper;
import es.nter.spring_cloud.application.services.TripService;
import es.nter.spring_cloud.exception.EntityNotFoundException;
import es.nter.spring_cloud.persistence.entities.Trip;
import es.nter.spring_cloud.persistence.repositories.TripRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository repository;
    private final TripMapper mapper;
    @Override
    public Page<Trip> getAll(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    @Override
    public Trip getById(Long id) {
        return repository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Cliente no encontrado")
        );
    }

    @Override
    @Transactional
    public Trip created(Trip trip) {
        return repository.save(trip);
    }

    @Override
    @Transactional
    public Trip updated(Long id, Trip trip) {
        Trip tripFound= getById(id);
        return mapper.toUpdate(tripFound, trip);
    }

    @Override
    @Transactional
    public void deleted(Long id) {
        repository.delete(getById(id));
    }
}
