--liquibase formatted sql
--changeset Anikeeva:20250119-04-create-table-readers

create table readers (
    id uuid,
    first_name varchar not null,
    last_name varchar not null,
    gender varchar not null,
    birth_date date not null,
    phone_number varchar(12) not null unique,
    primary key(id)
)