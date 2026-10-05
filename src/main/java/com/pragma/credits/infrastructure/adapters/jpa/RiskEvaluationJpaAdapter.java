package com.pragma.credits.infrastructure.adapters.jpa;

import com.pragma.credits.domain.model.RiskEvaluation;
import com.pragma.credits.domain.ports.RiskEvaluationRepository;
import com.pragma.credits.infrastructure.adapters.jpa.entities.RiskEvaluationJpaEntity;
import org.springframework.stereotype.Repository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RiskEvaluationJpaAdapter implements RiskEvaluationRepository {

    private final RiskEvaluationJpaRepository jpaRepository;
    private final ModelMapper modelMapper;

    public RiskEvaluationJpaAdapter(RiskEvaluationJpaRepository jpaRepository, ModelMapper modelMapper) {
        this.jpaRepository = jpaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RiskEvaluation save(RiskEvaluation riskEvaluation) {
        riskEvaluation.validate();
        RiskEvaluationJpaEntity entity = toEntity(riskEvaluation);
        RiskEvaluationJpaEntity savedEntity = jpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<RiskEvaluation> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<RiskEvaluation> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RiskEvaluation> findByCreditRequestId(Long creditRequestId) {
        return jpaRepository.findByCreditRequestId(creditRequestId).stream()
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

    private RiskEvaluationJpaEntity toEntity(RiskEvaluation domain) {
        return modelMapper.map(domain, RiskEvaluationJpaEntity.class);
    }

    private RiskEvaluation toDomain(RiskEvaluationJpaEntity entity) {
        return modelMapper.map(entity, RiskEvaluation.class);
    }
}