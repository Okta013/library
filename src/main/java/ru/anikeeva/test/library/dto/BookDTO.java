package ru.anikeeva.test.library.dto;

import ru.anikeeva.test.library.entities.Author;

import java.util.List;
import java.util.UUID;

public record BookDTO (
        UUID id,
        String title,
        int publicationYear,
        List<Author> authors
)
{}
