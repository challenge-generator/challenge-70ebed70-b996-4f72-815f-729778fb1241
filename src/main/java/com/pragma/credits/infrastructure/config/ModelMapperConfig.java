package com.pragma.credits.infrastructure.config;

import com.pragma.credits.domain.model.Client;
import com.pragma.credits.domain.model.CreditRequest;
import com.pragma.credits.domain.model.RiskEvaluation;
import com.pragma.credits.domain.model.Decision;
import com.pragma.credits.infrastructure.adapters.jpa.entities.ClientJpaEntity;
import com.pragma.credits.infrastructure.adapters.jpa.entities.CreditRequestJpaEntity;
import com.pragma.credits.infrastructure.adapters.jpa.entities.RiskEvaluationJpaEntity;
import com.pragma.credits.infrastructure.adapters.jpa.entities.DecisionJpaEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true)
                .setAmbiguityIgnored(false);

        configureClientMappings(modelMapper);
        configureCreditRequestMappings(modelMapper);
        configureRiskEvaluationMappings(modelMapper);
        configureDecisionMappings(modelMapper);

        return modelMapper;
    }

    private void configureClientMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(Client.class, ClientJpaEntity.class).addMappings(mapper -> {
            mapper.map(Client::name, ClientJpaEntity::setName);
            mapper.map(Client::lastName, ClientJpaEntity::setLastName);
            mapper.map(Client::documentType, ClientJpaEntity::setDocumentType);
            mapper.map(Client::documentNumber, ClientJpaEntity::setDocumentNumber);
            mapper.map(Client::email, ClientJpaEntity::setEmail);
            mapper.map(Client::phone, ClientJpaEntity::setPhone);
            mapper.map(Client::birthDate, ClientJpaEntity::setBirthDate);
            mapper.map(Client::monthlyIncome, ClientJpaEntity::setMonthlyIncome);
            mapper.map(Client::status, ClientJpaEntity::setStatus);
        });

        modelMapper.typeMap(ClientJpaEntity.class, Client.class).addMappings(mapper -> {
            mapper.map(ClientJpaEntity::getName, Client::setName);
            mapper.map(ClientJpaEntity::getLastName, Client::setLastName);
            mapper.map(ClientJpaEntity::getDocumentType, Client::setDocumentType);
            mapper.map(ClientJpaEntity::getDocumentNumber, Client::setDocumentNumber);
            mapper.map(ClientJpaEntity::getEmail, Client::setEmail);
            mapper.map(ClientJpaEntity::getPhone, Client::setPhone);
            mapper.map(ClientJpaEntity::getBirthDate, Client::setBirthDate);
            mapper.map(ClientJpaEntity::getMonthlyIncome, Client::setMonthlyIncome);
            mapper.map(ClientJpaEntity::getStatus, Client::setStatus);
        });
    }

    private void configureCreditRequestMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(CreditRequest.class, CreditRequestJpaEntity.class).addMappings(mapper -> {
            mapper.map(CreditRequest::requestedAmount, CreditRequestJpaEntity::setRequestedAmount);
            mapper.map(CreditRequest::termMonths, CreditRequestJpaEntity::setTermMonths);
            mapper.map(CreditRequest::purpose, CreditRequestJpaEntity::setPurpose);
            mapper.map(CreditRequest::interestRate, CreditRequestJpaEntity::setInterestRate);
            mapper.map(CreditRequest::status, CreditRequestJpaEntity::setStatus);
            mapper.map(CreditRequest::requestDate, CreditRequestJpaEntity::setRequestDate);
        });

        modelMapper.typeMap(CreditRequestJpaEntity.class, CreditRequest.class).addMappings(mapper -> {
            mapper.map(CreditRequestJpaEntity::getRequestedAmount, CreditRequest::setRequestedAmount);
            mapper.map(CreditRequestJpaEntity::getTermMonths, CreditRequest::setTermMonths);
            mapper.map(CreditRequestJpaEntity::getPurpose, CreditRequest::setPurpose);
            mapper.map(CreditRequestJpaEntity::getInterestRate, CreditRequest::setInterestRate);
            mapper.map(CreditRequestJpaEntity::getStatus, CreditRequest::setStatus);
            mapper.map(CreditRequestJpaEntity::getRequestDate, CreditRequest::setRequestDate);
        });
    }

    private void configureRiskEvaluationMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(RiskEvaluation.class, RiskEvaluationJpaEntity.class).addMappings(mapper -> {
            mapper.map(RiskEvaluation::creditRequestId, RiskEvaluationJpaEntity::setCreditRequestId);
            mapper.map(RiskEvaluation::score, RiskEvaluationJpaEntity::setScore);
            mapper.map(RiskEvaluation::riskLevel, RiskEvaluationJpaEntity::setRiskLevel);
            mapper.map(RiskEvaluation::maxReccomendedAmount, RiskEvaluationJpaEntity::setMaxReccomendedAmount);
            mapper.map(RiskEvaluation::evaluationDate, RiskEvaluationJpaEntity::setEvaluationDate);
            mapper.map(RiskEvaluation::details, RiskEvaluationJpaEntity::setDetails);
        });

        modelMapper.typeMap(RiskEvaluationJpaEntity.class, RiskEvaluation.class).addMappings(mapper -> {
            mapper.map(RiskEvaluationJpaEntity::getCreditRequestId, RiskEvaluation::setCreditRequestId);
            mapper.map(RiskEvaluationJpaEntity::getScore, RiskEvaluation::setScore);
            mapper.map(RiskEvaluationJpaEntity::getRiskLevel, RiskEvaluation::setRiskLevel);
            mapper.map(RiskEvaluationJpaEntity::getMaxReccomendedAmount, RiskEvaluation::setMaxReccomendedAmount);
            mapper.map(RiskEvaluationJpaEntity::getEvaluationDate, RiskEvaluation::setEvaluationDate);
            mapper.map(RiskEvaluationJpaEntity::getDetails, RiskEvaluation::setDetails);
        });
    }

    private void configureDecisionMappings(ModelMapper modelMapper) {
        modelMapper.typeMap(Decision.class, DecisionJpaEntity.class).addMappings(mapper -> {
            mapper.map(Decision::creditRequestId, DecisionJpaEntity::setCreditRequestId);
            mapper.map(Decision::approved, DecisionJpaEntity::setApproved);
            mapper.map(Decision::approvedAmount, DecisionJpaEntity::setApprovedAmount);
            mapper.map(Decision::interestRate, DecisionJpaEntity::setInterestRate);
            mapper.map(Decision::termMonths, DecisionJpaEntity::setTermMonths);
            mapper.map(Decision::status, DecisionJpaEntity::setStatus);
            mapper.map(Decision::decisionDate, DecisionJpaEntity::setDecisionDate);
            mapper.map(Decision::decisionMaker, DecisionJpaEntity::setDecisionMaker);
            mapper.map(Decision::observations, DecisionJpaEntity::setObservations);
        });

        modelMapper.typeMap(DecisionJpaEntity.class, Decision.class).addMappings(mapper -> {
            mapper.map(DecisionJpaEntity::getCreditRequestId, Decision::setCreditRequestId);
            mapper.map(DecisionJpaEntity::getApproved, Decision::setApproved);
            mapper.map(DecisionJpaEntity::getApprovedAmount, Decision::setApprovedAmount);
            mapper.map(DecisionJpaEntity::getInterestRate, Decision::setInterestRate);
            mapper.map(DecisionJpaEntity::getTermMonths, Decision::setTermMonths);
            mapper.map(DecisionJpaEntity::getStatus, Decision::setStatus);
            mapper.map(DecisionJpaEntity::getDecisionDate, Decision::setDecisionDate);
            mapper.map(DecisionJpaEntity::getDecisionMaker, Decision::setDecisionMaker);
            mapper.map(DecisionJpaEntity::getObservations, Decision::setObservations);
        });
    }
}