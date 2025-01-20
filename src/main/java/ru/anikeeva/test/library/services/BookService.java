package ru.anikeeva.test.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anikeeva.test.library.entities.Book;
import ru.anikeeva.test.library.repositories.BookRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book findBookById(final UUID id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Книга не найдена"));
    }
}