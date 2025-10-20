package es.nter.spring_cloud.application.services;

import es.nter.spring_cloud.persistence.entities.Client;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

public interface ClientService {
    Page<Client> getAll(int page, int size);
    @Named("ClientGetById")
    Client getById(Long id);
    Client created(Client client);
    Client updated(Long id, Client client);
    void deleted (Long id);
}
