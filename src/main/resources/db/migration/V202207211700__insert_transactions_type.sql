INSERT INTO transactions_type(id, description, operation, created_at)VALUES('PAYMENT', 'Payment', 'DEBIT', now());
INSERT INTO transactions_type(id, description, operation, created_at)VALUES('RECHARGE', 'Recharge', 'CREDIT', now());