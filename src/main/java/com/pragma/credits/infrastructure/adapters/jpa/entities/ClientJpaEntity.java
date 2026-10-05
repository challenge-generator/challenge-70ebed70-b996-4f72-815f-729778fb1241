package com.pragma.credits.infrastructure.adapters.jpa.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients", indexes = {
    @Index(name = "idx_client_identification", columnList = "identification_number", unique = true),
    @Index(name = "idx_client_email", columnList = "email", unique = true)
})
public class ClientJpaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "identification_number", nullable = false, unique = true, length = 50)
    private String identificationNumber;
    
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    
    @Column(name = "monthly_income", nullable = false, precision = 15, scale = 2)
    private BigDecimal monthlyIncome;
    
    @Column(name = "credit_score", nullable = false)
    private Integer creditScore;
    
    @Column(name = "employment_type", length = 50)
    private String employmentType;
    
    @Column(name = "employer_name", length = 200)
    private String employerName;
    
    @Column(name = "years_at_job", precision = 5, scale = 2)
    private BigDecimal yearsAtJob;
    
    @Column(name = "total_debt", precision = 15, scale = 2)
    private BigDecimal totalDebt;
    
    @Column(name = "has_foreclosures", nullable = false)
    private Boolean hasForeclosures;
    
    @Column(name = "has_bankruptcy", nullable = false)
    private Boolean hasBankruptcy;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @Version
    @Column(name = "version")
    private Long version;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CreditRequestJpaEntity> creditRequests = new ArrayList<>();
    
    public ClientJpaEntity() {
    }
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getIdentificationNumber() {
        return identificationNumber;
    }
    
    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }
    
    public void setMonthlyIncome(BigDecimal monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
    
    public Integer getCreditScore() {
        return creditScore;
    }
    
    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }
    
    public String getEmploymentType() {
        return employmentType;
    }
    
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }
    
    public String getEmployerName() {
        return employerName;
    }
    
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    public BigDecimal getYearsAtJob() {
        return yearsAtJob;
    }
    
    public void setYearsAtJob(BigDecimal yearsAtJob) {
        this.yearsAtJob = yearsAtJob;
    }
    
    public BigDecimal getTotalDebt() {
        return totalDebt;
    }
    
    public void setTotalDebt(BigDecimal totalDebt) {
        this.totalDebt = totalDebt;
    }
    
    public Boolean getHasForeclosures() {
        return hasForeclosures;
    }
    
    public void setHasForeclosures(Boolean hasForeclosures) {
        this.hasForeclosures = hasForeclosures;
    }
    
    public Boolean getHasBankruptcy() {
        return hasBankruptcy;
    }
    
    public void setHasBankruptcy(Boolean hasBankruptcy) {
        this.hasBankruptcy = hasBankruptcy;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    public List<CreditRequestJpaEntity> getCreditRequests() {
        return creditRequests;
    }
    
    public void setCreditRequests(List<CreditRequestJpaEntity> creditRequests) {
        this.creditRequests = creditRequests;
    }
    
    public void addCreditRequest(CreditRequestJpaEntity creditRequest) {
        creditRequests.add(creditRequest);
        creditRequest.setClient(this);
    }
    
    public void removeCreditRequest(CreditRequestJpaEntity creditRequest) {
        creditRequests.remove(creditRequest);
        creditRequest.setClient(null);
    }
}