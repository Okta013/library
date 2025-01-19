package ru.anikeeva.test.library.dto;

import ru.anikeeva.test.library.entities.enums.EnumGender;

import java.time.LocalDate;
import java.util.UUID;

public record ReaderDTO (
        UUID id,
        String firstName,
        String lastName,
        EnumGender gender,
        LocalDate birthDate,
        String phoneNumber
)
{}
