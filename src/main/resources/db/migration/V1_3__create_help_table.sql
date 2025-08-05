CREATE TABLE help (
                      id BIGSERIAL PRIMARY KEY,
                      beneficiary_id BIGINT NOT NULL,
                      psp_type VARCHAR(50) NOT NULL,
                      psp_payment_id VARCHAR(255) NOT NULL,
                      amount INT NOT NULL,
                      creation_instant TIMESTAMP WITH TIME ZONE NOT NULL default now(),
                      verification_status VARCHAR(20) NOT NULL,
                      accident_description TEXT NOT NULL,
                      last_verification_status_instant TIMESTAMP WITH TIME ZONE,
                      FOREIGN KEY (beneficiary_id) REFERENCES beneficiary(id)
);