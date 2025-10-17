package es.nter.spring_cloud.application.services.impl;

import es.nter.spring_cloud.application.mappers.ClientMapper;
import es.nter.spring_cloud.application.services.ClientService;
import es.nter.spring_cloud.exception.EntityNotFoundException;
import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.persistence.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    @Override
    public Page<Client> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }

    @Override
    public Client getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cliente not found")
        );
    }

    @Override
    @Transactional
    public Client created(Client client) {
        return repository.save(client);
    }

    @Override
    @Transactional
    public Client updated(Long id, Client client) {
        Client clientFound = getById(id);
        return mapper.toUpdate(clientFound, client);
    }

    @Override
    @Transactional
    public void deleted(Long id) {
        repository.delete(getById(id));

    }
}
