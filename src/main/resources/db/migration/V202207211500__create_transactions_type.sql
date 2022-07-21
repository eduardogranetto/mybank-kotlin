CREATE TYPE transactions_type_operation AS ENUM ('CREDIT', 'DEBIT');


CREATE TABLE transactions_type (
    id VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    operation transactions_type_operation NOT NULL,
    PRIMARY KEY (id)
);