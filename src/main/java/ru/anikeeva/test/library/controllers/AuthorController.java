package ru.anikeeva.test.library.controllers;

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
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/popular")
    public AuthorDTO findMostPopularAuthor(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return authorService.findMostPopularAuthor(startDate, endDate);
    }
}
