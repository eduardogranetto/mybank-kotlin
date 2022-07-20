CREATE TABLE accounts (
    id uuid DEFAULT uuid_generate_v4(),
    document VARCHAR NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    balance NUMERIC(12,2) NOT NULL default 0.0,
    PRIMARY KEY (id),
    UNIQUE(document)
);