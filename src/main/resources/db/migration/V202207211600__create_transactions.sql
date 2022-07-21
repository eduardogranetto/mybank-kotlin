CREATE TABLE transactions (
    id uuid DEFAULT uuid_generate_v4(),
    account_id uuid NOT NULL,
    transaction_type_id VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    value NUMERIC(12,2) NOT NULL default 0.0,
    PRIMARY KEY (id),
    CONSTRAINT fk_transaction_account_id FOREIGN KEY(account_id) REFERENCES accounts(id),
    CONSTRAINT fk_transaction_type_id FOREIGN KEY(transaction_type_id) REFERENCES transactions_type(id)
);