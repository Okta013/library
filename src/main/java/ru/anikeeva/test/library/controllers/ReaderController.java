package ru.anikeeva.test.library.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anikeeva.test.library.dto.ReaderDTO;
import ru.anikeeva.test.library.services.ReaderService;

import java.util.List;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
@Tag(name = "Читатели", description = "Операции с читателями")
public class ReaderController {
    private final ReaderService readerService;

    @GetMapping("/reading")
    @Operation(summary = "Поиск самого активного читателя",
            description = "Отображает читателя, который взял больше всего книг")
    public ReaderDTO findMostReadingReader() {
        return readerService.findMostReadingReader();
    }

    @GetMapping("/debtors")
    @Operation(summary = "Поиск должников",
            description = "Отображает список читателей, отсортированных по количеству невозвращенных книг")
    public List<ReaderDTO> findDebtors() {
        return readerService.findDebtors();
    }
}
