package es.nter.spring_cloud.application.services;

import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.persistence.entities.ClientTrip;
import es.nter.spring_cloud.persistence.entities.Trip;

import java.util.Set;

public interface ClientTripService {

    Set<ClientTrip> getAll();
    Set<ClientTrip> getByTrip(Long tripId);
    Set<ClientTrip> getByClient(Long clientId);
    ClientTrip created(Client client, Trip trip);
}
