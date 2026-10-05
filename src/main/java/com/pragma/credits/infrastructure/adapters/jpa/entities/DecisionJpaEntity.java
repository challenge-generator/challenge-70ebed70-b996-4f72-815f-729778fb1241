package com.pragma.credits.infrastructure.adapters.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "decisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DecisionJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "credit_request_id", nullable = false, unique = true)
    private UUID creditRequestId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_request_id", insertable = false, updatable = false)
    private CreditRequestJpaEntity creditRequest;

    @Column(name = "decision_date", nullable = false)
    @Builder.Default
    private LocalDate decisionDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "decision_type", nullable = false, length = 20)
    private DecisionType decisionType;

    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved;

    @Column(name = "amount_approved", precision = 19, scale = 4)
    private BigDecimal amountApproved;

    @Column(name = "interest_rate_approved", precision = 5, scale = 4)
    private BigDecimal interestRateApproved;

    @Column(name = "term_months_approved")
    private Integer termMonthsApproved;

    @Column(name = "reason", columnDefinition = "TEXT")
    private String reason;

    @Column(name = "reviewer_id", length = 100)
    private String reviewerId;

    @Column(name = "reviewer_name", length = 200)
    private String reviewerName;

    @Column(name = "approved_at")
    private LocalDate approvedAt;

    @Column(name = "rejected_at")
    private LocalDate rejectedAt;

    @Column(name = "conditions", columnDefinition = "TEXT")
    private String conditions;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    public enum DecisionType {
        AUTO_APPROVED,
        MANUAL_APPROVED,
        AUTO_REJECTED,
        MANUAL_REJECTED,
        PENDING_REVIEW,
        CONDITIONAL_APPROVAL
    }

    public boolean isApproved() {
        return Boolean.TRUE.equals(isApproved);
    }

    public boolean isRejected() {
        return Boolean.FALSE.equals(isApproved);
    }

    public boolean isConditional() {
        return DecisionType.CONDITIONAL_APPROVAL.equals(decisionType);
    }
}