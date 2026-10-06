CREATE TABLE transactions (
    id                  BIGSERIAL           PRIMARY KEY,
    account_id          BIGINT              NOT NULL REFERENCES accounts(id),
    category_id         BIGINT              REFERENCES categories(id),
    transaction_date    DATE                NOT NULL,
    description         VARCHAR(500)        NOT NULL,
    amount              NUMERIC(19,4)       NOT NULL,
    transaction_hash    VARCHAR(64)         NOT NULL UNIQUE,
    manually_categorised BOOLEAN            NOT NULL DEFAULT FALSE,
    created_at          TIMESTAMPTZ         NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_transactions_account_id     ON transactions(account_id);
CREATE INDEX idx_transactions_transaction_date ON transactions(transaction_date);
CREATE INDEX idx_transactions_category_id    ON transactions(category_id);
