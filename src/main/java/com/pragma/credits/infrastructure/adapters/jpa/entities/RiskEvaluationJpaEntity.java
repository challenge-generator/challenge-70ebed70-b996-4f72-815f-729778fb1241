package com.pragma.credits.infrastructure.adapters.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "risk_evaluations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RiskEvaluationJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "credit_request_id", nullable = false)
    private UUID creditRequestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_request_id", insertable = false, updatable = false)
    private CreditRequestJpaEntity creditRequest;

    @Column(name = "evaluation_date", nullable = false)
    @Builder.Default
    private LocalDate evaluationDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "evaluation_type", nullable = false, length = 50)
    private EvaluationType evaluationType;

    @Column(name = "score", precision = 5, scale = 2)
    private BigDecimal score;

    @Enumerated(EnumType.STRING)
    @Column(name = "risk_level", nullable = false, length = 20)
    private RiskLevel riskLevel;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "evaluated_by", length = 100)
    private String evaluatedBy;

    @Column(name = "model_version", length = 50)
    private String modelVersion;

    @Column(name = "confidence_score", precision = 5, scale = 2)
    private BigDecimal confidenceScore;

    @Column(name = "recommendation", length = 500)
    private String recommendation;

    public boolean isApproved() {
        return Boolean.TRUE.equals(isApproved);
    }

    public String generateEvaluationSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Evaluación de Riesgo - ").append(evaluationDate).append("\n");
        summary.append("Tipo: ").append(evaluationType).append("\n");
        summary.append("Nivel de Riesgo: ").append(riskLevel).append("\n");
        if (score != null) {
            summary.append("Puntuación: ").append(score).append("\n");
        }
        if (recommendation != null) {
            summary.append("Recomendación: ").append(recommendation).append("\n");
        }
        return summary.toString();
    }

    public enum EvaluationType {
        CREDIT_HISTORY,
        INCOME_VERIFICATION,
        DEBT_TO_INCOME,
        EMPLOYMENT_VERIFICATION,
        COLLATERAL,
        OVERALL_RISK
    }

    public enum RiskLevel {
        LOW,
        MEDIUM,
        HIGH,
        VERY_HIGH,
        UNKNOWN
    }
}