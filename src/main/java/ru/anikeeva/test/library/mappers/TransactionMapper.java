package ru.anikeeva.test.library.mappers;

import org.mapstruct.Mapper;
import ru.anikeeva.test.library.dto.TransactionDTO;
import ru.anikeeva.test.library.entities.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toTransaction(TransactionMapper transactionDTO);

    TransactionDTO toTransactionDTO(Transaction transaction);
}
