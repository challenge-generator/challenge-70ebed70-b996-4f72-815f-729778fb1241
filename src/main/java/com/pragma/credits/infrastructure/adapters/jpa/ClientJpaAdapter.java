package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.domain.model.Client;
import com.pragma.credits.domain.ports.ClientRepository;
import com.pragma.credits.infrastructure.adapters.jpa.entities.ClientJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ClientJpaAdapter implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;
    private final ClientMapper clientMapper;

    public ClientJpaAdapter(ClientJpaRepository clientJpaRepository, ClientMapper clientMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client save(Client client) {
        client.validate();
        ClientJpaEntity entity = clientMapper.toEntity(client);
        ClientJpaEntity savedEntity = clientJpaRepository.save(entity);
        return clientMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return clientJpaRepository.findById(id)
                .map(clientMapper::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return clientJpaRepository.findAll().stream()
                .map(clientMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (clientJpaRepository.existsById(id)) {
            clientJpaRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        return clientJpaRepository.existsById(id);
    }

    @Override
    public List<Client> findByIdentificationNumber(String identificationNumber) {
        return clientJpaRepository.findByIdentificationNumber(identificationNumber).stream()
                .map(clientMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> findByEmail(String email) {
        return clientJpaRepository.findByEmail(email).stream()
                .map(clientMapper::toDomain)
                .collect(Collectors.toList());
    }
}