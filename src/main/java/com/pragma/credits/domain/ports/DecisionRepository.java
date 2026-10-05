package com.pragma.credits.domain.ports;

import com.pragma.credits.domain.model.Decision;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DecisionRepository {
    
    Decision save(Decision decision);
    
    Optional<Decision> findById(UUID id);
    
    List<Decision> findAll();
    
    List<Decision> findByCreditRequestId(UUID creditRequestId);
    
    Optional<Decision> findTopByCreditRequestIdOrderByDecisionDateDesc(UUID creditRequestId);
    
    void deleteById(UUID id);
    
    boolean existsById(UUID id);
    
    long countByCreditRequestId(UUID creditRequestId);
}