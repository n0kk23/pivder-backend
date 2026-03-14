--liquibase formatted sql
--changeset nokk:004-create-likes-table

CREATE TABLE IF NOT EXISTS likes
(
    id         UUID        PRIMARY KEY,
    liker_id   UUID        NOT NULL     REFERENCES accounts(id),
    liked_id   UUID        NOT NULL     REFERENCES accounts(id),
    status     VARCHAR(10) NOT NULL     DEFAULT 'pending' CHECK(status in ('pending', 'accepted', 'declined')),
    created_at TIMESTAMPTZ NOT NULL     DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL     DEFAULT NOW()
);

--rollback DROP TABLE IF EXISTS likes;