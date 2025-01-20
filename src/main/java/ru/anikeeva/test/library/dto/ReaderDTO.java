package ru.anikeeva.test.library.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import ru.anikeeva.test.library.entities.enums.EnumGender;

import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "Сущность читателя")
public record ReaderDTO (
        @Schema(description = "Уникальный идентификатор читателя", example = "5ba1abd4-c88d-4c89-972f-c60b9ca47e07",
                accessMode = Schema.AccessMode.READ_ONLY) UUID id,
        @Schema(description = "Имя читателя", example = "Евгения") String firstName,
        @Schema(description = "Фамилия читателя", example = "Краснова") String lastName,
        @Schema(description = "Пол читателя", allowableValues = {"MALE", "FEMALE"}) EnumGender gender,
        @Schema(description = "Дата рождения читателя", example = "1997-11-09") LocalDate birthDate,
        @Schema(description = "12-значный номер телефона читателя", example = "89177777777") String phoneNumber
)
{}