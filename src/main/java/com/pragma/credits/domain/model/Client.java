package com.pragma.credits.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Entidad de dominio que representa a un cliente.
 * Contiene atributos normalizados y validaciones de negocio.
 */
public record Client(
    @NotNull(message = "El ID del cliente no puede ser nulo")
    UUID id,

    @NotBlank(message = "El nombre completo no puede estar vacío")
    @Size(max = 100, message = "El nombre completo no puede exceder los 100 caracteres")
    String fullName,

    @NotBlank(message = "El número de identificación no puede estar vacío")
    @Pattern(regexp = "^[0-9]{6,20}$", message = "El número de identificación debe ser numérico y tener entre 6 y 20 dígitos")
    String identificationNumber,

    @NotBlank(message = "El tipo de identificación no puede estar vacío")
    @Size(min = 2, max = 10, message = "El tipo de identificación debe tener entre 2 y 10 caracteres")
    String identificationType,

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    LocalDate birthDate,

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "El formato del correo electrónico es inválido")
    String email,

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 200, message = "La dirección no puede exceder los 200 caracteres")
    String address,

    @NotBlank(message = "El número de teléfono no puede estar vacío")
    @Pattern(regexp = "^\\+[0-9]{10,15}$", message = "El número de teléfono debe incluir código de país y tener entre 10 y 15 dígitos")
    String phoneNumber,

    @NotBlank(message = "El estado civil no puede estar vacío")
    @Size(max = 20, message = "El estado civil no puede exceder los 20 caracteres")
    String maritalStatus
) {
    /**
     * Valida las invariantes del cliente.
     * @throws IllegalArgumentException si alguna validación falla.
     */
    public void validate() {
        if (birthDate != null && birthDate.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("El cliente debe ser mayor de 18 años");
        }
        if (identificationNumber != null && !identificationNumber.matches("^[0-9]{6,20}$")) {
            throw new IllegalArgumentException("El número de identificación debe ser numérico y tener entre 6 y 20 dígitos");
        }
        if (email != null && !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("El formato del correo electrónico es inválido");
        }
    }

    /**
     * Calcula la edad del cliente basada en su fecha de nacimiento.
     * @return la edad en años.
     */
    public int calculateAge() {
        if (birthDate == null) {
            throw new IllegalStateException("La fecha de nacimiento no puede ser nula");
        }
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}