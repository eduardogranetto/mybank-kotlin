ALTER TABLE accounts ADD CONSTRAINT positive_balance CHECK (balance >= 0);