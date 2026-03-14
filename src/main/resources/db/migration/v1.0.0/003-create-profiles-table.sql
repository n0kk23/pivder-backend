--liquibase formatted sql
--changeset nokk:003-create-profiles-table

CREATE TABLE IF NOT EXISTS profiles
(
    id               UUID         PRIMARY KEY,
    account_id       UUID         REFERENCES accounts(id),
    gender           VARCHAR(20)  NOT NULL CHECK(gender in ('MAN', 'WOMAN')),
    prefer_gender    VARCHAR(20)  NOT NULL CHECK(prefer_gender in ('MAN', 'WOMAN', 'BOTH')),
    description      VARCHAR(255) NOT NULL,
    university_group VARCHAR(20)  NOT NULL CHECK(LENGTH(university_group) > 2),
    created_at       TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMPTZ  NOT NULL DEFAULT NOW()
);

--rollback DROP IF EXISTS profiles;