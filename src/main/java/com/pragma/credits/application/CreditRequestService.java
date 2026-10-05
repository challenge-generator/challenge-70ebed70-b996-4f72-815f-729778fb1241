package com.pragma.credits.application;

import com.pragma.credits.domain.model.Client;
import com.pragma.credits.domain.model.CreditRequest;
import com.pragma.credits.domain.model.RiskEvaluation;
import com.pragma.credits.domain.model.Decision;
import com.pragma.credits.domain.ports.ClientRepository;
import com.pragma.credits.domain.ports.CreditRequestRepository;
import com.pragma.credits.domain.ports.RiskEvaluationRepository;
import com.pragma.credits.domain.ports.DecisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CreditRequestService {

    private final ClientRepository clientRepository;
    private final CreditRequestRepository creditRequestRepository;
    private final RiskEvaluationRepository riskEvaluationRepository;
    private final DecisionRepository decisionRepository;

    public CreditRequestService(
            ClientRepository clientRepository,
            CreditRequestRepository creditRequestRepository,
            RiskEvaluationRepository riskEvaluationRepository,
            DecisionRepository decisionRepository) {
        this.clientRepository = clientRepository;
        this.creditRequestRepository = creditRequestRepository;
        this.riskEvaluationRepository = riskEvaluationRepository;
        this.decisionRepository = decisionRepository;
    }

    public CreditRequest createCreditRequest(CreditRequest creditRequest) {
        creditRequest.validate();
        
        Optional<Client> existingClient = clientRepository.findById(creditRequest.clientId());
        if (existingClient.isEmpty()) {
            throw new IllegalArgumentException("El cliente no existe en el sistema");
        }
        
        Client client = existingClient.get();
        if (!isClientEligible(client)) {
            throw new IllegalStateException("El cliente no cumple los requisitos para solicitar un crédito");
        }
        
        CreditRequest savedRequest = creditRequestRepository.save(creditRequest);
        
        RiskEvaluation initialEvaluation = createInitialRiskEvaluation(savedRequest.id(), client);
        riskEvaluationRepository.save(initialEvaluation);
        
        return savedRequest;
    }

    public Optional<CreditRequest> findCreditRequestById(UUID id) {
        return creditRequestRepository.findById(id);
    }

    public List<CreditRequest> findCreditRequestsByClientId(UUID clientId) {
        return creditRequestRepository.findByClientId(clientId);
    }

    public List<CreditRequest> findAllCreditRequests() {
        return creditRequestRepository.findAll();
    }

    public CreditRequest updateCreditRequestStatus(UUID requestId, String newStatus) {
        Optional<CreditRequest> existingRequest = creditRequestRepository.findById(requestId);
        if (existingRequest.isEmpty()) {
            throw new IllegalArgumentException("Solicitud de crédito no encontrada");
        }
        
        CreditRequest currentRequest = existingRequest.get();
        CreditRequest updatedRequest = new CreditRequest(
            currentRequest.id(),
            currentRequest.clientId(),
            currentRequest.amount(),
            currentRequest.termMonths(),
            currentRequest.purpose(),
            newStatus,
            currentRequest.requestDate(),
            currentRequest.interestRate()
        );
        
        return creditRequestRepository.save(updatedRequest);
    }

    public RiskEvaluation evaluateRisk(UUID creditRequestId, BigDecimal income, BigDecimal expenses) {
        Optional<CreditRequest> requestOpt = creditRequestRepository.findById(creditRequestId);
        if (requestOpt.isEmpty()) {
            throw new IllegalArgumentException("Solicitud de crédito no encontrada");
        }
        
        CreditRequest request = requestOpt.get();
        Optional<Client> clientOpt = clientRepository.findById(request.clientId());
        if (clientOpt.isEmpty()) {
            throw new IllegalStateException("Cliente asociado no encontrado");
        }
        
        Client client = clientOpt.get();
        BigDecimal requestedAmount = request.amount();
        int termMonths = request.termMonths();
        
        BigDecimal debtToIncomeRatio = calculateDebtToIncomeRatio(requestedAmount, termMonths, income);
        boolean hasNegativeHistory = client.hasNegativeCreditHistory();
        boolean incomeSufficient = income.compareTo(requestedAmount.multiply(BigDecimal.valueOf(0.3))) > 0;
        
        boolean approved = debtToIncomeRatio.compareTo(BigDecimal.valueOf(0.4)) < 0
                && !hasNegativeHistory
                && incomeSufficient;
        
        String evaluationDetails = String.format(
            "DTI: %.2f, Historial negativo: %s, Ingreso suficiente: %s",
            debtToIncomeRatio,
            hasNegativeHistory ? "Sí" : "No",
            incomeSufficient ? "Sí" : "No"
        );
        
        RiskEvaluation evaluation = new RiskEvaluation(
            UUID.randomUUID(),
            creditRequestId,
            approved,
            evaluationDetails,
            LocalDate.now(),
            debtToIncomeRatio,
            hasNegativeHistory
        );
        
        evaluation.validate();
        return riskEvaluationRepository.save(evaluation);
    }

    public Decision processDecision(UUID creditRequestId, String decisionType, String comments) {
        Optional<CreditRequest> requestOpt = creditRequestRepository.findById(creditRequestId);
        if (requestOpt.isEmpty()) {
            throw new IllegalArgumentException("Solicitud de crédito no encontrada");
        }
        
        Optional<RiskEvaluation> evaluationOpt = riskEvaluationRepository.findByCreditRequestId(creditRequestId);
        if (evaluationOpt.isEmpty()) {
            throw new IllegalStateException("No existe evaluación de riesgo para esta solicitud");
        }
        
        RiskEvaluation evaluation = evaluationOpt.get();
        if (!evaluation.isApproved()) {
            decisionType = "REJECTED";
        }
        
        Decision decision = new Decision(
            UUID.randomUUID(),
            creditRequestId,
            decisionType,
            comments,
            LocalDate.now(),
            "SYSTEM"
        );
        
        decision.validate();
        Decision savedDecision = decisionRepository.save(decision);
        
        String newStatus = "APPROVED".equals(decisionType) ? "APROBADA" : 
                          "REJECTED".equals(decisionType) ? "RECHAZADA" : "EN_REVISION";
        updateCreditRequestStatus(creditRequestId, newStatus);
        
        return savedDecision;
    }

    private boolean isClientEligible(Client client) {
        int age = client.calculateAge();
        return age >= 18 && age <= 70;
    }

    private BigDecimal calculateDebtToIncomeRatio(BigDecimal amount, int months, BigDecimal monthlyIncome) {
        BigDecimal monthlyPayment = amount.calculateMonthlyPayment(BigDecimal.valueOf(0.15));
        return monthlyPayment.divide(monthlyIncome, 4, java.math.RoundingMode.HALF_UP);
    }

    private RiskEvaluation createInitialRiskEvaluation(UUID creditRequestId, Client client) {
        return new RiskEvaluation(
            UUID.randomUUID(),
            creditRequestId,
            false,
            "Evaluación inicial pendiente",
            LocalDate.now(),
            BigDecimal.ZERO,
            client.hasNegativeCreditHistory()
        );
    }
}