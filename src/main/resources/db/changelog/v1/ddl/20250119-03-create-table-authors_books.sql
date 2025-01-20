--liquibase formatted sql
--changeset Anikeeva:20250119-03-create-table-authors_books

CREATE TABLE authors_books (
    author_id uuid,
    book_id uuid,
    primary key (author_id, book_id),
    foreign key (author_id) references authors (id) on delete cascade,
    foreign key (book_id) references books (id) on delete cascade
);