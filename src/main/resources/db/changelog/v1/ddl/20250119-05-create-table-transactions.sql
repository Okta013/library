--liquibase formatted sql
--changeset Anikeeva:20250119-05-create-table-transactions

create table transactions (
    id uuid,
    operation varchar not null,
    date timestamp not null,
    reader_id uuid not null,
    book_id uuid not null,
    primary key(id)
)