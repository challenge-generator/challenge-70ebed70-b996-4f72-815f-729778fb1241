package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.domain.model.CreditRequest;
import com.pragma.credits.domain.ports.CreditRequestRepository;
import com.pragma.credits.infrastructure.adapters.jpa.entities.CreditRequestJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CreditRequestJpaAdapter implements CreditRequestRepository {

    private final CreditRequestJpaRepository creditRequestJpaRepository;
    private final CreditRequestMapper creditRequestMapper;

    public CreditRequestJpaAdapter(
            CreditRequestJpaRepository creditRequestJpaRepository,
            CreditRequestMapper creditRequestMapper) {
        this.creditRequestJpaRepository = creditRequestJpaRepository;
        this.creditRequestMapper = creditRequestMapper;
    }

    @Override
    public CreditRequest save(CreditRequest creditRequest) {
        creditRequest.validate();
        CreditRequestJpaEntity entity = creditRequestMapper.toEntity(creditRequest);
        CreditRequestJpaEntity savedEntity = creditRequestJpaRepository.save(entity);
        return creditRequestMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<CreditRequest> findById(UUID id) {
        return creditRequestJpaRepository.findById(id)
                .map(creditRequestMapper::toDomain);
    }

    @Override
    public List<CreditRequest> findAll() {
        return creditRequestJpaRepository.findAll().stream()
                .map(creditRequestMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        if (creditRequestJpaRepository.existsById(id)) {
            creditRequestJpaRepository.deleteById(id);
        }
    }

    @Override
    public boolean existsById(UUID id) {
        return creditRequestJpaRepository.existsById(id);
    }

    @Override
    public List<CreditRequest> findByClientId(UUID clientId) {
        return creditRequestJpaRepository.findByClientId(clientId).stream()
                .map(creditRequestMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditRequest> findByStatus(String status) {
        return creditRequestJpaRepository.findByStatus(status).stream()
                .map(creditRequestMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditRequest> findByStatusAndClientId(String status, UUID clientId) {
        return creditRequestJpaRepository.findByStatusAndClientId(status, clientId).stream()
                .map(creditRequestMapper::toDomain)
                .collect(Collectors.toList());
    }
}