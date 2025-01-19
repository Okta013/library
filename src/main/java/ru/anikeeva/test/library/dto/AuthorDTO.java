package ru.anikeeva.test.library.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.anikeeva.test.library.entities.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Schema(description = "Сущность автора книг")
public record AuthorDTO(
        @Schema(description = "Уникальный идентификатор автора",
                example = "e68aa2e0-edb0-42f3-ad73-b3831f5ccb7d", accessMode = Schema.AccessMode.READ_ONLY) UUID id,
        @Schema(description = "Имя автора", example = "Григорий") String firstName,
        @Schema(description = "Фамилия автора", example = "Арсеньев") String lastName,
        @Schema(description = "Дата рождения автора", example = "1997-01-12") LocalDate birthDate,
        @Schema(description = "Написанные книги") List<Book> books
)
{}
