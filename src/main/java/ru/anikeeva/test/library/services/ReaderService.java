package ru.anikeeva.test.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anikeeva.test.library.dto.ReaderDTO;
import ru.anikeeva.test.library.entities.Reader;
import ru.anikeeva.test.library.mappers.ReaderMapper;
import ru.anikeeva.test.library.repositories.ReaderRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final ReaderMapper readerMapper;

    public ReaderDTO findMostReadingReader() {
        return readerMapper.toReaderDTO(readerRepository.findMostReadingReader());
    }

    public List<ReaderDTO> findDebtors() {
        return readerRepository.findDebtors().stream().map(readerMapper::toReaderDTO).toList();
    }

    public Reader findReaderById(UUID id) {
        return readerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Читатель не найден"));
    }
}
