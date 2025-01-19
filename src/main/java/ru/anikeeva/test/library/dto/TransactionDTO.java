package ru.anikeeva.test.library.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.anikeeva.test.library.entities.Book;
import ru.anikeeva.test.library.entities.Reader;
import ru.anikeeva.test.library.entities.enums.EnumOperation;

import java.time.LocalDateTime;
import java.util.UUID;

@Schema(description = "Сущность транзакции")
public record TransactionDTO (
        @Schema(description = "Уникальный идентификатор транзакции", example = "9bbeda87-93d7-41f4-8ca2-39407c94b9f1",
                accessMode = Schema.AccessMode.READ_ONLY) UUID id,
        @Schema(description = "Операция с книгой", allowableValues = {"TAKING", "RETURNING"}) EnumOperation operation,
        @Schema(description = "Дата проведения транзакции", example = "2024-02-15T11:14:27") LocalDateTime date,
        @Schema(description = "Читатель, производящий операцию над книгой") Reader reader,
        @Schema(description = "Книга, над которой производится операция") Book book
)
{}