package es.nter.spring_cloud.persistence.repositories;

import es.nter.spring_cloud.persistence.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
