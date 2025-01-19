package ru.anikeeva.test.library.dto;

import ru.anikeeva.test.library.entities.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record AuthorDTO(
        UUID id,
        String firstName,
        String lastName,
        LocalDate birthDate,
        List<Book> books
)
{}
