package ru.anikeeva.test.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.anikeeva.test.library.dto.AuthorDTO;
import ru.anikeeva.test.library.entities.Author;
import ru.anikeeva.test.library.mappers.AuthorMapper;
import ru.anikeeva.test.library.repositories.AuthorRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorDTO findMostPopularAuthor(final LocalDateTime startDate, final LocalDateTime endDate) {
        Pageable pageable = PageRequest.of(0, 1);
        List<Author> authors = authorRepository.findMostPopularAuthors(startDate, endDate, pageable);
        Author mostPopularAuthor = authors.isEmpty() ? null : authors.getFirst();
        return authorMapper.toAuthorDTO(mostPopularAuthor);
    }
}