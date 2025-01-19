package ru.anikeeva.test.library.controllers;

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
public class ReaderController {
    private final ReaderService readerService;

    @GetMapping("/reading")
    public ReaderDTO findMostReadingReader() {
        return readerService.findMostReadingReader();
    }

    @GetMapping("/debtors")
    public List<ReaderDTO> findDebtors() {
        return readerService.findDebtors();
    }
}
