package ru.anikeeva.test.library.mappers;

import org.mapstruct.Mapper;
import ru.anikeeva.test.library.dto.AuthorDTO;
import ru.anikeeva.test.library.entities.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO toAuthorDTO(Author author);
}