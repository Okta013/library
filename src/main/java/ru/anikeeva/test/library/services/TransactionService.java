package ru.anikeeva.test.library.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anikeeva.test.library.dto.TransactionDTO;
import ru.anikeeva.test.library.entities.Transaction;
import ru.anikeeva.test.library.entities.enums.EnumOperation;
import ru.anikeeva.test.library.mappers.TransactionMapper;
import ru.anikeeva.test.library.repositories.TransactionRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final ReaderService readerService;
    private final BookService bookService;

    @Transactional
    public TransactionDTO makeTransaction(final UUID readerId, final UUID bookId) {
        Transaction lastTransaction = transactionRepository.findLastTransactionByBookAndReader(readerId, bookId);
        Transaction newTransaction = new Transaction();
        newTransaction.setDate(LocalDateTime.now());
        if (lastTransaction != null) {
            newTransaction.setOperation((lastTransaction.getOperation() == EnumOperation.TAKING) ?
                    EnumOperation.RETURNING : EnumOperation.TAKING);
        }
        else {
            newTransaction.setOperation(EnumOperation.TAKING);
        }
        newTransaction.setReader(readerService.findReaderById(readerId));
        newTransaction.setBook(bookService.findBookById(bookId));
        Transaction savedTransaction = transactionRepository.save(newTransaction);
        return transactionMapper.toTransactionDTO(savedTransaction);
    }
}