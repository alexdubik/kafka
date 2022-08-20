CREATE TABLE IF NOT EXISTS house (
    id        UUID      PRIMARY KEY,
    name      VARCHAR   NOT NULL UNIQUE,
    type      VARCHAR   NOT NULL,
    floor     INTEGER   NOT NULL
);