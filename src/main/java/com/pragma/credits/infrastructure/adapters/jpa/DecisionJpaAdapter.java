package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.domain.model.Decision;
import com.pragma.credits.domain.ports.DecisionRepository;
import com.pragma.credits.infrastructure.adapters.jpa.entities.DecisionJpaEntity;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DecisionJpaAdapter implements DecisionRepository {

    private final DecisionJpaRepository jpaRepository;
    private final ModelMapper modelMapper;

    public DecisionJpaAdapter(DecisionJpaRepository jpaRepository, ModelMapper modelMapper) {
        this.jpaRepository = jpaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Decision save(Decision decision) {
        DecisionJpaEntity entity = toEntity(decision);
        DecisionJpaEntity savedEntity = jpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Decision> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Decision> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Decision> findByCreditRequestId(Long creditRequestId) {
        return jpaRepository.findByCreditRequestId(creditRequestId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Decision> findLatestByCreditRequestId(Long creditRequestId) {
        return jpaRepository.findTopByCreditRequestIdOrderByDecisionDateDesc(creditRequestId)
                .map(this::toDomain);
    }

    @Override
    public List<Decision> findByStatus(String status) {
        return jpaRepository.findByStatus(status).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Decision> findByDecisionDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return jpaRepository.findByDecisionDateBetween(startDate, endDate).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    private DecisionJpaEntity toEntity(Decision domain) {
        return modelMapper.map(domain, DecisionJpaEntity.class);
    }

    private Decision toDomain(DecisionJpaEntity entity) {
        return modelMapper.map(entity, Decision.class);
    }
}