--liquibase formatted sql
--changeset Anikeeva:20250119-01-create-table-books

CREATE TABLE books (
                       id uuid,
                       title varchar not null,
                       publication_year int not null,
                       primary key(id)
);