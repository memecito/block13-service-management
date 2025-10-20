package es.nter.spring_cloud.application.services.impl;

import es.nter.spring_cloud.application.mappers.TripMapper;
import es.nter.spring_cloud.application.services.ClientService;
import es.nter.spring_cloud.application.services.ClientTripService;
import es.nter.spring_cloud.application.services.TripService;
import es.nter.spring_cloud.exception.BadRequestException;
import es.nter.spring_cloud.exception.EntityNotFoundException;
import es.nter.spring_cloud.exception.ForbiddenOperationException;
import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.persistence.entities.ClientTrip;
import es.nter.spring_cloud.persistence.entities.Trip;
import es.nter.spring_cloud.persistence.entities.TripStatus;
import es.nter.spring_cloud.persistence.repositories.TripRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository repository;
    private final TripMapper mapper;

    private final ClientService clientService;
    private final ClientTripService clientTripService;
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
    public Set<Client> getPassenger(Long id) {
        Set<ClientTrip> clientTrips= getById(id).getClients();
        return clientTrips.stream().map(
                clientTrip -> clientService.getById(clientTrip.getClient().getId()))
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public Trip created(Trip trip) {
        trip.setStatus(TripStatus.ONTIME);
        return repository.save(trip);
    }

    @Override
    @Transactional
    public Trip addPassenger(Long tripId, Long clientId) {
        Trip tripFound= getById(tripId);
        Client newClient= clientService.getById(clientId);
        if((long) tripFound.getClients().size() >40)
            throw new ForbiddenOperationException("Numero maximo de pasageros superado");

        tripFound.getClients().add(clientTripService.created(newClient,tripFound));
        return tripFound;
    }

    @Override
    @Transactional
    public Trip updated(Long id, Trip trip) {
        Trip tripFound= getById(id);
        return mapper.toUpdate(tripFound, trip);
    }

    @Override
    @Transactional
    public Trip updatedStatus(Long tripId, String newStatus) {
      Trip tripFound= getById(tripId);
        final String normalizedStatus = newStatus.trim().toUpperCase();
        boolean isValidStatus = Arrays.stream(TripStatus.values())
                .anyMatch(enumValue -> enumValue.name().equals(normalizedStatus));

        if (!isValidStatus) {
            throw new BadRequestException("El estado '" + newStatus + "' no es válido.");
        }
        tripFound.setStatus(TripStatus.valueOf(normalizedStatus));
        return tripFound;
    }

    @Override
    @Transactional
    public void deleted(Long id) {
        getById(id).setStatus(TripStatus.CANCELLED);
    }
}
