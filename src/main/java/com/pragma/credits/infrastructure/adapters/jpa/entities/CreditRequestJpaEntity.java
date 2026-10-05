package com.pragma.credits.infrastructure.adapters.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "credit_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditRequestJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private ClientJpaEntity client;

    @Column(name = "amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false, length = 3)
    @Builder.Default
    private String currency = "USD";

    @Column(name = "term_months", nullable = false)
    private Integer termMonths;

    @Column(name = "interest_rate", nullable = false, precision = 5, scale = 4)
    private BigDecimal interestRate;

    @Column(name = "purpose", length = 500)
    private String purpose;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    @Builder.Default
    private CreditRequestStatus status = CreditRequestStatus.PENDING;

    @Column(name = "requested_at", nullable = false)
    @Builder.Default
    private LocalDate requestedAt = LocalDate.now();

    @Column(name = "processed_at")
    private LocalDate processedAt;

    @Column(name = "monthly_payment", precision = 19, scale = 4)
    private BigDecimal monthlyPayment;

    @OneToMany(mappedBy = "creditRequest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<RiskEvaluationJpaEntity> riskEvaluations = new ArrayList<>();

    @OneToOne(mappedBy = "creditRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private DecisionJpaEntity decision;

    public void addRiskEvaluation(RiskEvaluationJpaEntity evaluation) {
        riskEvaluations.add(evaluation);
        evaluation.setCreditRequest(this);
    }

    public void removeRiskEvaluation(RiskEvaluationJpaEntity evaluation) {
        riskEvaluations.remove(evaluation);
        evaluation.setCreditRequest(null);
    }

    public void calculateMonthlyPayment() {
        if (amount != null && interestRate != null && termMonths != null && termMonths > 0) {
            BigDecimal monthlyRate = interestRate.divide(BigDecimal.valueOf(12), 8, java.math.RoundingMode.HALF_UP);
            BigDecimal factor = monthlyRate.add(BigDecimal.ONE).pow(termMonths);
            BigDecimal factorMinusOne = factor.subtract(BigDecimal.ONE);
            monthlyPayment = amount.multiply(monthlyRate).multiply(factor).divide(factorMinusOne, 4, java.math.RoundingMode.HALF_UP);
        }
    }

    public enum CreditRequestStatus {
        PENDING,
        UNDER_REVIEW,
        APPROVED,
        REJECTED,
        CANCELLED
    }
}