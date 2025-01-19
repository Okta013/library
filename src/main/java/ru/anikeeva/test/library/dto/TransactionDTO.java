package ru.anikeeva.test.library.dto;

import ru.anikeeva.test.library.entities.Book;
import ru.anikeeva.test.library.entities.Reader;
import ru.anikeeva.test.library.entities.enums.EnumOperation;

import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDTO (
        UUID id,
        EnumOperation operation,
        LocalDateTime date,
        Reader reader,
        Book book
)
{}