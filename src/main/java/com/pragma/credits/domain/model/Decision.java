package com.pragma.credits.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Decision(
    UUID id,
    UUID creditRequestId,
    String decisionType,
    String status,
    BigDecimal approvedAmount,
    BigDecimal interestRate,
    Integer termInMonths,
    String reason,
    LocalDateTime decidedAt,
    String decidedBy
) {
    public Decision {
        if (id == null) {
            throw new IllegalArgumentException("El identificador de la decisión no puede ser nulo");
        }
        if (creditRequestId == null) {
            throw new IllegalArgumentException("El identificador de la solicitud de crédito no puede ser nulo");
        }
        if (decisionType == null || decisionType.isBlank()) {
            throw new IllegalArgumentException("El tipo de decisión no puede estar vacío");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("El estado de la decisión no puede estar vacío");
        }
    }

    public void validate() {
        validateDecisionType();
        validateStatus();
        validateApprovedAmount();
        validateInterestRate();
        validateTermInMonths();
    }

    private void validateDecisionType() {
        if (!isValidDecisionType(decisionType)) {
            throw new IllegalArgumentException(
                "Tipo de decisión inválido. Valores permitidos: APPROVED, REJECTED, CONDITIONAL"
            );
        }
    }

    private boolean isValidDecisionType(String type) {
        return "APPROVED".equals(type) || "REJECTED".equals(type) || "CONDITIONAL".equals(type);
    }

    private void validateStatus() {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException(
                "Estado inválido. Valores permitidos: PENDING, FINAL, APPEALED"
            );
        }
    }

    private boolean isValidStatus(String statusValue) {
        return "PENDING".equals(statusValue) || "FINAL".equals(statusValue) || "APPEALED".equals(statusValue);
    }

    private void validateApprovedAmount() {
        if ("APPROVED".equals(decisionType) || "CONDITIONAL".equals(decisionType)) {
            if (approvedAmount == null) {
                throw new IllegalArgumentException("El monto aprobado es obligatorio para decisiones aprobadas o condicionales");
            }
            if (approvedAmount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("El monto aprobado debe ser mayor que cero");
            }
            if (approvedAmount.compareTo(new BigDecimal("1000000")) > 0) {
                throw new IllegalArgumentException("El monto aprobado no puede exceder el límite máximo permitido");
            }
        }
    }

    private void validateInterestRate() {
        if ("APPROVED".equals(decisionType) || "CONDITIONAL".equals(decisionType)) {
            if (interestRate == null) {
                throw new IllegalArgumentException("La tasa de interés es obligatoria para decisiones aprobadas o condicionales");
            }
            if (interestRate.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("La tasa de interés debe ser mayor que cero");
            }
            if (interestRate.compareTo(new BigDecimal("1.0")) > 0) {
                throw new IllegalArgumentException("La tasa de interés no puede exceder el 100%");
            }
        }
    }

    private void validateTermInMonths() {
        if ("APPROVED".equals(decisionType) || "CONDITIONAL".equals(decisionType)) {
            if (termInMonths == null) {
                throw new IllegalArgumentException("El plazo en meses es obligatorio para decisiones aprobadas o condicionales");
            }
            if (termInMonths <= 0) {
                throw new IllegalArgumentException("El plazo en meses debe ser mayor que cero");
            }
            if (termInMonths > 360) {
                throw new IllegalArgumentException("El plazo no puede exceder 360 meses (30 años)");
            }
        }
    }

    public boolean isApproved() {
        return "APPROVED".equals(decisionType) && "FINAL".equals(status);
    }

    public boolean isRejected() {
        return "REJECTED".equals(decisionType);
    }

    public boolean isConditional() {
        return "CONDITIONAL".equals(decisionType);
    }

    public boolean isPending() {
        return "PENDING".equals(status);
    }

    public boolean isFinal() {
        return "FINAL".equals(status);
    }

    public BigDecimal calculateMonthlyPayment() {
        if (!isApproved() && !isConditional()) {
            throw new IllegalStateException("Solo se puede calcular cuota para decisiones aprobadas o condicionales");
        }
        if (approvedAmount == null || interestRate == null || termInMonths == null) {
            throw new IllegalStateException("Faltan datos para calcular la cuota mensual");
        }
        BigDecimal monthlyRate = interestRate.divide(new BigDecimal("12"), 10, java.math.RoundingMode.HALF_UP);
        BigDecimal factor = monthlyRate.add(BigDecimal.ONE).pow(termInMonths);
        BigDecimal numerator = monthlyRate.multiply(factor);
        BigDecimal denominator = factor.subtract(BigDecimal.ONE);
        return approvedAmount.multiply(numerator).divide(denominator, 2, java.math.RoundingMode.HALF_UP);
    }

    public String generateDecisionSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Decisión: ").append(decisionType).append("\n");
        summary.append("Estado: ").append(status).append("\n");
        if (approvedAmount != null) {
            summary.append("Monto aprobado: $").append(approvedAmount).append("\n");
        }
        if (interestRate != null) {
            summary.append("Tasa de interés: ").append(interestRate.multiply(new BigDecimal("100"))).append("%\n");
        }
        if (termInMonths != null) {
            summary.append("Plazo: ").append(termInMonths).append(" meses\n");
        }
        if (reason != null && !reason.isBlank()) {
            summary.append("Motivo: ").append(reason).append("\n");
        }
        if (decidedAt != null) {
            summary.append("Fecha: ").append(decidedAt).append("\n");
        }
        if (decidedBy != null && !decidedBy.isBlank()) {
            summary.append("Decidido por: ").append(decidedBy).append("\n");
        }
        return summary.toString();
    }

    public Decision withStatus(String newStatus) {
        return new Decision(
            this.id,
            this.creditRequestId,
            this.decisionType,
            newStatus,
            this.approvedAmount,
            this.interestRate,
            this.termInMonths,
            this.reason,
            this.decidedAt,
            this.decidedBy
        );
    }

    public Decision withApprovedAmount(BigDecimal newAmount) {
        return new Decision(
            this.id,
            this.creditRequestId,
            this.decisionType,
            this.status,
            newAmount,
            this.interestRate,
            this.termInMonths,
            this.reason,
            this.decidedAt,
            this.decidedBy
        );
    }

    public static Decision createPendingDecision(UUID creditRequestId) {
        return new Decision(
            UUID.randomUUID(),
            creditRequestId,
            "PENDING",
            "PENDING",
            null,
            null,
            null,
            "Awaiting revisión",
            null,
            null
        );
    }
}