package es.nter.spring_cloud.persistence.repositories;

import es.nter.spring_cloud.persistence.entities.ClientTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClientTripRepository extends JpaRepository<ClientTrip, Long> {
    Set<ClientTrip> findByClientId(Long id);
    Set<ClientTrip> findByTripId(Long id);
}
