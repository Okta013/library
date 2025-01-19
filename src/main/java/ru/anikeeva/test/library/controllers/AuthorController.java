package ru.anikeeva.test.library.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.anikeeva.test.library.dto.AuthorDTO;
import ru.anikeeva.test.library.services.AuthorService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
@Tag(name = "Авторы", description = "Операции с авторами книг")
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/popular")
    @Operation(summary = "Поиск самого популярного автора",
            description = "Отображает самого популярного автора за указанный период даты и времени")
    public AuthorDTO findMostPopularAuthor(
            @RequestParam @Parameter(description = "Дата и время нижней границы периода поиска",
                    example = "2024-01-01T09:00:00") LocalDateTime startDate,
            @RequestParam @Parameter(description = "Дата и время верхней границы периода поиска",
                    example = "2024-06-01T18:00:00") LocalDateTime endDate
    )
    {
        return authorService.findMostPopularAuthor(startDate, endDate);
    }
}
