package ru.anikeeva.test.library.mappers;

import org.mapstruct.Mapper;
import ru.anikeeva.test.library.dto.ReaderDTO;
import ru.anikeeva.test.library.entities.Reader;

@Mapper(componentModel = "spring")
public interface ReaderMapper {
    ReaderDTO toReaderDTO(Reader reader);
}