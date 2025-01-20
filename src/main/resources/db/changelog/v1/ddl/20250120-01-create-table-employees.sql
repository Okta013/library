--liquibase formatted sql
--changeset Anikeeva:20250120-01-create-table-employees

create table employees (
    id uuid,
    login varchar not null unique,
    password varchar not null,
    primary key (id)
)