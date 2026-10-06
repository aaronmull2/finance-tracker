CREATE TABLE import_runs (
    id              BIGSERIAL       PRIMARY KEY,
    account_id      BIGINT          NOT NULL REFERENCES accounts(id),
    file_name       VARCHAR(255)    NOT NULL,
    file_hash       VARCHAR(64)     NOT NULL UNIQUE,
    records_read    INT             NOT NULL DEFAULT 0,
    records_written INT             NOT NULL DEFAULT 0,
    records_rejected INT            NOT NULL DEFAULT 0,
    amount_total    NUMERIC(19,4)   NOT NULL DEFAULT 0,
    status          VARCHAR(50)     NOT NULL DEFAULT 'STARTED',
    started_at      TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
    completed_at    TIMESTAMPTZ
);
