package com.pragma.credits.application;

import com.pragma.credits.domain.model.Client;
import com.pragma.credits.domain.model.CreditRequest;
import com.pragma.credits.domain.model.RiskEvaluation;
import com.pragma.credits.domain.model.Decision;
import com.pragma.credits.domain.ports.ClientRepository;
import com.pragma.credits.domain.ports.CreditRequestRepository;
import com.pragma.credits.domain.ports.RiskEvaluationRepository;
import com.pragma.credits.domain.ports.DecisionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreditRequestServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private CreditRequestRepository creditRequestRepository;

    @Mock
    private RiskEvaluationRepository riskEvaluationRepository;

    @Mock
    private DecisionRepository decisionRepository;

    @InjectMocks
    private CreditRequestService creditRequestService;

    private Client testClient;
    private CreditRequest testCreditRequest;
    private RiskEvaluation testRiskEvaluation;
    private Decision testDecision;

    @BeforeEach
    void setUp() {
        testClient = new Client(
            UUID.randomUUID(),
            "Juan",
            "Pérez",
            "DNI",
            "12345678",
            "juan@example.com",
            "+5491112345678",
            LocalDate.of(1985, 5, 15),
            new BigDecimal("5000.00"),
            750
        );

        testCreditRequest = new CreditRequest(
            UUID.randomUUID(),
            testClient.id(),
            new BigDecimal("50000.00"),
            24,
            "CONSUMO",
            new BigDecimal("0.15"),
            null,
            "PENDING",
            null
        );

        testRiskEvaluation = new RiskEvaluation(
            UUID.randomUUID(),
            testCreditRequest.id(),
            LocalDate.now(),
            new BigDecimal("0.30"),
            80,
            85,
            new BigDecimal("10000.00"),
            "MEDIUM",
            "APPROVE",
            "Perfil adecuado para el monto solicitado",
            true
        );

        testDecision = new Decision(
            UUID.randomUUID(),
            testCreditRequest.id(),
            "APPROVED",
            "María García",
            "Analista de Crédito",
            "Evaluación de riesgo favorable",
            null,
            new BigDecimal("0.12"),
            new BigDecimal("2350.00")
        );
    }

    @Test
    void createCreditRequest_shouldSaveRequest_whenClientExistsAndDataIsValid() {
        when(clientRepository.findById(testClient.id())).thenReturn(Optional.of(testClient));
        when(creditRequestRepository.save(any(CreditRequest.class))).thenReturn(testCreditRequest);

        CreditRequest result = creditRequestService.createCreditRequest(testCreditRequest);

        assertNotNull(result);
        assertEquals(testCreditRequest.id(), result.id());
        verify(creditRequestRepository).save(any(CreditRequest.class));
    }

    @Test
    void createCreditRequest_shouldThrowException_whenClientDoesNotExist() {
        UUID nonExistentClientId = UUID.randomUUID();
        when(clientRepository.findById(nonExistentClientId)).thenReturn(Optional.empty());

        CreditRequest invalidRequest = new CreditRequest(
            UUID.randomUUID(),
            nonExistentClientId,
            new BigDecimal("30000.00"),
            12,
            "CONSUMO",
            new BigDecimal("0.15"),
            null,
            "PENDING",
            null
        );

        assertThrows(IllegalArgumentException.class, 
            () -> creditRequestService.createCreditRequest(invalidRequest));
        verify(creditRequestRepository, never()).save(any());
    }

    @Test
    void evaluateCreditRequest_shouldCreateRiskEvaluation_whenRequestIsValid() {
        when(creditRequestRepository.findById(testCreditRequest.id()))
            .thenReturn(Optional.of(testCreditRequest));
        when(riskEvaluationRepository.save(any(RiskEvaluation.class)))
            .thenReturn(testRiskEvaluation);

        RiskEvaluation result = creditRequestService.evaluateCreditRequest(
            testCreditRequest.id(), testRiskEvaluation);

        assertNotNull(result);
        assertTrue(result.isApproved());
        assertEquals("MEDIUM", result.riskLevel());
        verify(riskEvaluationRepository).save(any(RiskEvaluation.class));
    }

    @Test
    void makeDecision_shouldApproveRequest_whenRiskEvaluationIsApproved() {
        when(creditRequestRepository.findById(testCreditRequest.id()))
            .thenReturn(Optional.of(testCreditRequest));
        when(riskEvaluationRepository.findByCreditRequestId(testCreditRequest.id()))
            .thenReturn(Optional.of(testRiskEvaluation));
        when(decisionRepository.save(any(Decision.class))).thenReturn(testDecision);

        Decision result = creditRequestService.makeDecision(
            testCreditRequest.id(), testDecision);

        assertNotNull(result);
        assertEquals("APPROVED", result.decisionType());
        verify(decisionRepository).save(any(Decision.class));
    }

    @Test
    void calculateMonthlyPayment_shouldComputeCorrectly() {
        BigDecimal amount = new BigDecimal("50000.00");
        BigDecimal annualRate = new BigDecimal("0.15");
        int termMonths = 24;

        BigDecimal monthlyPayment = creditRequestService.calculateMonthlyPayment(
            amount, annualRate, termMonths);

        assertNotNull(monthlyPayment);
        assertTrue(monthlyPayment.compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void getCreditRequestById_shouldReturnRequest_whenExists() {
        when(creditRequestRepository.findById(testCreditRequest.id()))
            .thenReturn(Optional.of(testCreditRequest));

        Optional<CreditRequest> result = creditRequestService.getCreditRequestById(
            testCreditRequest.id());

        assertTrue(result.isPresent());
        assertEquals(testCreditRequest.id(), result.get().id());
    }

    @Test
    void getCreditRequestById_shouldReturnEmpty_whenNotExists() {
        UUID nonExistentId = UUID.randomUUID();
        when(creditRequestRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        Optional<CreditRequest> result = creditRequestService.getCreditRequestById(nonExistentId);

        assertFalse(result.isPresent());
    }

    @Test
    void getCreditRequestsByClientId_shouldReturnClientRequests() {
        when(creditRequestRepository.findByClientId(testClient.id()))
            .thenReturn(java.util.List.of(testCreditRequest));

        var result = creditRequestService.getCreditRequestsByClientId(testClient.id());

        assertEquals(1, result.size());
        assertEquals(testClient.id(), result.get(0).clientId());
    }
}