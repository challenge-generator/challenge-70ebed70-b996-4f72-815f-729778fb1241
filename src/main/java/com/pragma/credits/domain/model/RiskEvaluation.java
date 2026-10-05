package com.pragma.credits.domain.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad de dominio que representa una evaluación de riesgo para una solicitud de crédito.
 * Contiene atributos normalizados y validaciones de negocio.
 */
public record RiskEvaluation(
    @NotNull(message = "El ID de la evaluación de riesgo no puede ser nulo")
    UUID id,

    @NotNull(message = "El ID de la solicitud de crédito no puede ser nulo")
    UUID creditRequestId,

    @NotNull(message = "La puntuación de riesgo no puede ser nula")
    @DecimalMin(value = "0.0", message = "La puntuación de riesgo debe ser al menos 0")
    @DecimalMax(value = "100.0", message = "La puntuación de riesgo no puede exceder 100")
    BigDecimal riskScore,

    @NotBlank(message = "El nivel de riesgo no puede estar vacío")
    @Size(max = 20, message = "El nivel de riesgo no puede exceder los 20 caracteres")
    String riskLevel,

    @NotBlank(message = "El detalle de la evaluación no puede estar vacío")
    @Size(max = 500, message = "El detalle de la evaluación no puede exceder los 500 caracteres")
    String evaluationDetails,

    @NotNull(message = "La fecha de evaluación no puede ser nula")
    @PastOrPresent(message = "La fecha de evaluación no puede ser futura")
    LocalDate evaluationDate,

    @NotBlank(message = "El método de evaluación no puede estar vacío")
    @Size(max = 50, message = "El método de evaluación no puede exceder los 50 caracteres")
    String evaluationMethod
) {
    /**
     * Valida las invariantes de la evaluación de riesgo.
     * @throws IllegalArgumentException si alguna validación falla.
     */
    public void validate() {
        if (riskScore != null && (riskScore.compareTo(BigDecimal.ZERO) < 0 || riskScore.compareTo(BigDecimal.valueOf(100)) > 0)) {
            throw new IllegalArgumentException("La puntuación de riesgo debe estar entre 0 y 100");
        }
        if (riskLevel != null && !riskLevel.matches("^(BAJO|MEDIO|ALTO|CRITICO)$")) {
            throw new IllegalArgumentException("El nivel de riesgo debe ser uno de: BAJO, MEDIO, ALTO, CRITICO");
        }
        if (evaluationMethod != null && !evaluationMethod.matches("^(AUTOMATICO|MANUAL|HIBRIDO)$")) {
            throw new IllegalArgumentException("El método de evaluación debe ser uno de: AUTOMATICO, MANUAL, HIBRIDO");
        }
    }

    /**
     * Determina si la evaluación de riesgo aprueba la solicitud.
     * @return true si la solicitud es aprobada, false en caso contrario.
     */
    public boolean isApproved() {
        if (riskScore == null || riskLevel == null) {
            throw new IllegalStateException("La puntuación y el nivel de riesgo no pueden ser nulos");
        }
        return riskScore.compareTo(BigDecimal.valueOf(50)) >= 0 && !riskLevel.equals("ALTO") && !riskLevel.equals("CRITICO");
    }

    /**
     * Genera un resumen de la evaluación de riesgo.
     * @return un string con el resumen de la evaluación.
     */
    public String generateEvaluationSummary() {
        return String.format("Evaluación de riesgo para solicitud %s: puntuación %.2f (%s), método %s",
                creditRequestId, riskScore, riskLevel, evaluationMethod);
    }
}