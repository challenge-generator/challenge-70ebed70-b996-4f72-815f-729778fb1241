package com.pragma.credits.domain.ports;

import com.pragma.credits.domain.model.RiskEvaluation;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RiskEvaluationRepository {
    
    RiskEvaluation save(RiskEvaluation riskEvaluation);
    
    Optional<RiskEvaluation> findById(UUID id);
    
    List<RiskEvaluation> findAll();
    
    List<RiskEvaluation> findByCreditRequestId(UUID creditRequestId);
    
    void deleteById(UUID id);
    
    boolean existsById(UUID id);
}