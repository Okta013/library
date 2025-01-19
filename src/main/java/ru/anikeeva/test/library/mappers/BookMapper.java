package ru.anikeeva.test.library.mappers;

import org.mapstruct.Mapper;
import ru.anikeeva.test.library.dto.BookDTO;
import ru.anikeeva.test.library.entities.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookDTO bookDTO);

    BookDTO toBookDTO(Book book);
}
