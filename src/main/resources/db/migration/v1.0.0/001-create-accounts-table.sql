--liquibase formatted sql
--changeset nokk:001-create-accounts-table

CREATE TABLE IF NOT EXISTS accounts
(
    id             UUID         PRIMARY KEY,
    username       VARCHAR(24)  NOT NULL UNIQUE CHECK (LENGTH(username) >= 6),
    hash_password  TEXT         NOT NULL,
    created_at     TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at     TIMESTAMPTZ  NOT NULL DEFAULT NOW()
);

--rollback DROP TABLE IF EXISTS clients;