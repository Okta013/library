--liquibase formatted sql
--changeset Anikeeva:20250119-02-create-table-authors

create table authors (
    id uuid,
    first_name varchar not null,
    last_name varchar not null,
    birth_date date,
    primary key(id)
)