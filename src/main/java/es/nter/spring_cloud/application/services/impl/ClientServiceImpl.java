package es.nter.spring_cloud.application.services.impl;

import es.nter.spring_cloud.application.services.ClientService;
import es.nter.spring_cloud.persistence.entities.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    @Override
    public Page<Client> getAll(int page, int size) {
        return null;
    }

    @Override
    public Client getById(Long id) {
        return null;
    }

    @Override
    public Client created(Client client) {
        return null;
    }

    @Override
    public Client updated(Long id, Client client) {
        return null;
    }

    @Override
    public void deleted(Long id) {

    }
}
