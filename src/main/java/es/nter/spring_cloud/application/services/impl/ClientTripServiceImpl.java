package es.nter.spring_cloud.application.services.impl;

import es.nter.spring_cloud.application.services.ClientTripService;
import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.persistence.entities.ClientTrip;
import es.nter.spring_cloud.persistence.entities.Trip;
import es.nter.spring_cloud.persistence.repositories.ClientTripRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientTripServiceImpl implements ClientTripService {

    private final ClientTripRepository repository;
    @Override
    public Set<ClientTrip> getAll() {
        return (Set<ClientTrip>) repository.findAll();
    }

    @Override
    public Set<ClientTrip> getByTrip(Long tripId) {
        return repository.findByTripId(tripId);
    }

    @Override
    public Set<ClientTrip> getByClient(Long clientId) {
        return repository.findByClientId(clientId);
    }

    @Override
    @Transactional
    public ClientTrip created(Client client, Trip trip) {
        ClientTrip newClientTrip= new ClientTrip();
        newClientTrip.setClient(client);
        newClientTrip.setTrip(trip);
        return repository.save(newClientTrip);
    }
}
