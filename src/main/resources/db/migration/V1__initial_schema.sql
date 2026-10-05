-- Script de migración Flyway para crear el esquema de base de datos normalizado
-- Sistema de gestión de créditos con modelo de datos en 3NF

-- Tabla de clientes
CREATE TABLE clients (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    document_type VARCHAR(20) NOT NULL,
    document_number VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(20),
    birth_date DATE NOT NULL,
    monthly_income DECIMAL(15, 2) NOT NULL,
    credit_score INTEGER DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_clients_document_number ON clients(document_number);
CREATE INDEX idx_clients_email ON clients(email);

-- Tabla de solicitudes de crédito
CREATE TABLE credit_requests (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    client_id UUID NOT NULL REFERENCES clients(id) ON DELETE RESTRICT,
    requested_amount DECIMAL(15, 2) NOT NULL,
    term_months INTEGER NOT NULL CHECK (term_months > 0),
    purpose VARCHAR(255) NOT NULL,
    interest_rate DECIMAL(5, 4) NOT NULL,
    monthly_payment DECIMAL(15, 2),
    status VARCHAR(30) NOT NULL DEFAULT 'PENDING',
    rejection_reason TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chk_requested_amount_positive CHECK (requested_amount > 0)
);

CREATE INDEX idx_credit_requests_client_id ON credit_requests(client_id);
CREATE INDEX idx_credit_requests_status ON credit_requests(status);

-- Tabla de evaluaciones de riesgo
CREATE TABLE risk_evaluations (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    credit_request_id UUID NOT NULL UNIQUE REFERENCES credit_requests(id) ON DELETE CASCADE,
    evaluation_date DATE NOT NULL,
    monthly_debt_ratio DECIMAL(5, 4) NOT NULL,
    employment_stability_score INTEGER NOT NULL CHECK (employment_stability_score BETWEEN 0 AND 100),
    credit_history_score INTEGER NOT NULL CHECK (credit_history_score BETWEEN 0 AND 100),
    collateral_value DECIMAL(15, 2) DEFAULT 0,
    risk_level VARCHAR(20) NOT NULL,
    recommendation VARCHAR(20) NOT NULL,
    evaluator_notes TEXT,
    is_approved BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_risk_evaluations_credit_request_id ON risk_evaluations(credit_request_id);
CREATE INDEX idx_risk_evaluations_risk_level ON risk_evaluations(risk_level);

-- Tabla de decisiones
CREATE TABLE decisions (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    credit_request_id UUID NOT NULL REFERENCES credit_requests(id) ON DELETE CASCADE,
    decision_type VARCHAR(20) NOT NULL,
    decision_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    approver_name VARCHAR(100) NOT NULL,
    approver_role VARCHAR(50) NOT NULL,
    decision_reason TEXT NOT NULL,
    conditions TEXT,
    interest_rate_final DECIMAL(5, 4),
    monthly_payment_final DECIMAL(15, 2),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_decisions_credit_request_id ON decisions(credit_request_id);
CREATE INDEX idx_decisions_decision_type ON decisions(decision_type);

-- Tabla de cuotas (para seguimiento de pagos)
CREATE TABLE installments (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    credit_request_id UUID NOT NULL REFERENCES credit_requests(id) ON DELETE CASCADE,
    installment_number INTEGER NOT NULL CHECK (installment_number > 0),
    due_date DATE NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    principal_amount DECIMAL(15, 2) NOT NULL,
    interest_amount DECIMAL(15, 2) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    paid_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_installments_credit_request_id ON installments(credit_request_id);
CREATE INDEX idx_installments_due_date ON installments(due_date);
CREATE INDEX idx_installments_status ON installments(status);

-- Función para actualizar timestamps automáticamente
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

-- Triggers para actualizar updated_at
CREATE TRIGGER update_clients_updated_at
    BEFORE UPDATE ON clients
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

CREATE TRIGGER update_credit_requests_updated_at
    BEFORE UPDATE ON credit_requests
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();