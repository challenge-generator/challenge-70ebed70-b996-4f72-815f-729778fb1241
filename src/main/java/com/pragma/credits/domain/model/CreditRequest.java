package com.pragma.credits.domain.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad de dominio que representa una solicitud de crédito.
 * Contiene atributos normalizados y validaciones de negocio.
 */
public record CreditRequest(
    @NotNull(message = "El ID de la solicitud no puede ser nulo")
    UUID id,

    @NotNull(message = "El ID del cliente no puede ser nulo")
    UUID clientId,

    @NotNull(message = "El monto solicitado no puede ser nulo")
    @DecimalMin(value = "100.00", message = "El monto solicitado debe ser al menos 100")
    BigDecimal requestedAmount,

    @NotNull(message = "El plazo en meses no puede ser nulo")
    @Positive(message = "El plazo en meses debe ser positivo")
    Integer termMonths,

    @NotBlank(message = "El propósito del crédito no puede estar vacío")
    @Size(max = 100, message = "El propósito del crédito no puede exceder los 100 caracteres")
    String purpose,

    @NotBlank(message = "El estado de la solicitud no puede estar vacío")
    @Size(max = 20, message = "El estado de la solicitud no puede exceder los 20 caracteres")
    String status,

    @NotNull(message = "La fecha de solicitud no puede ser nula")
    @PastOrPresent(message = "La fecha de solicitud no puede ser futura")
    LocalDate requestDate,

    @NotNull(message = "La fecha de decisión no puede ser nula si el estado es aprobado o rechazado")
    LocalDate decisionDate
) {
    /**
     * Valida las invariantes de la solicitud de crédito.
     * @throws IllegalArgumentException si alguna validación falla.
     */
    public void validate() {
        if (requestedAmount != null && requestedAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto solicitado debe ser positivo");
        }
        if (termMonths != null && termMonths <= 0) {
            throw new IllegalArgumentException("El plazo en meses debe ser positivo");
        }
        if (status != null && !status.matches("^(PENDIENTE|EN_EVALUACION|APROBADO|RECHAZADO)$")) {
            throw new IllegalArgumentException("El estado de la solicitud debe ser uno de: PENDIENTE, EN_EVALUACION, APROBADO, RECHAZADO");
        }
        if ((status != null && (status.equals("APROBADO") || status.equals("RECHAZADO"))) && decisionDate == null) {
            throw new IllegalArgumentException("La fecha de decisión es obligatoria si el estado es APROBADO o RECHAZADO");
        }
    }

    /**
     * Calcula el monto de la cuota mensual basado en el monto solicitado y el plazo.
     * @param interestRate tasa de interés anual.
     * @return el monto de la cuota mensual.
     */
    public BigDecimal calculateMonthlyPayment(BigDecimal interestRate) {
        if (requestedAmount == null || termMonths == null) {
            throw new IllegalStateException("El monto solicitado y el plazo en meses no pueden ser nulos");
        }
        if (interestRate == null || interestRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La tasa de interés debe ser positiva");
        }
        BigDecimal monthlyRate = interestRate.divide(BigDecimal.valueOf(12), 10, BigDecimal.ROUND_HALF_UP);
        BigDecimal denominator = BigDecimal.ONE.subtract(BigDecimal.ONE.divide(
            BigDecimal.ONE.add(monthlyRate).pow(termMonths), 10, BigDecimal.ROUND_HALF_UP
        ));
        return requestedAmount.multiply(monthlyRate).divide(denominator, 2, BigDecimal.ROUND_HALF_UP);
    }
}