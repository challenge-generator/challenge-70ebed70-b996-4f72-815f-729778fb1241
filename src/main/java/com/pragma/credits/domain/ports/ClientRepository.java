package com.pragma.credits.domain.ports;

import com.pragma.credits.domain.model.Client;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    
    Optional<Client> findById(UUID id);
    
    Optional<Client> findByIdentificationNumber(String identificationNumber);
    
    List<Client> findAll();
    
    List<Client> findByStatus(String status);
    
    List<Client> findByAgeBetween(int minAge, int maxAge);
    
    List<Client> findByIncomeGreaterThanEqual(java.math.BigDecimal minimumIncome);
    
    boolean existsByIdentificationNumber(String identificationNumber);
    
    boolean existsByEmail(String email);
    
    Client save(Client client);
    
    void deleteById(UUID id);
    
    long count();
    
    long countByStatus(String status);
}