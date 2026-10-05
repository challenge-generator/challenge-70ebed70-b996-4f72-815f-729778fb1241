package com.pragma.credits.domain.ports;

import com.pragma.credits.domain.model.CreditRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CreditRequestRepository {
    
    Optional<CreditRequest> findById(UUID id);
    
    List<CreditRequest> findAll();
    
    List<CreditRequest> findByClientId(UUID clientId);
    
    List<CreditRequest> findByStatus(String status);
    
    List<CreditRequest> findByStatusAndCreatedAtAfter(String status, LocalDateTime date);
    
    List<CreditRequest> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount);
    
    List<CreditRequest> findByClientIdAndStatus(UUID clientId, String status);
    
    boolean existsByClientIdAndStatus(UUID clientId, String status);
    
    boolean existsByClientIdAndStatusIn(UUID clientId, List<String> statuses);
    
    CreditRequest save(CreditRequest creditRequest);
    
    void deleteById(UUID id);
    
    long count();
    
    long countByStatus(String status);
    
    long countByClientId(UUID clientId);
}