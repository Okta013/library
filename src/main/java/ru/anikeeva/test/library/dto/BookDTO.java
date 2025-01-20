package ru.anikeeva.test.library.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.anikeeva.test.library.entities.Author;

import java.util.List;
import java.util.UUID;

@Schema(description = "Сущность книги")
public record BookDTO (
        @Schema(description = "Уникальный идентификатор книги", example = "2b188ca2-0a5f-4990-855c-5933455665a9",
                accessMode = Schema.AccessMode.READ_ONLY) UUID id,
        @Schema(description = "Название книги", example = "Последнее желание") String title,
        @Schema(description = "Год первой публикации книги", example = "1995") int publicationYear,
        @Schema(description = "Список авторов книги") List<Author> authors
)
{}