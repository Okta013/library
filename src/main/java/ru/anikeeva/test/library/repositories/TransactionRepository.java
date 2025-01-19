package ru.anikeeva.test.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.anikeeva.test.library.entities.Transaction;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    @Query("SELECT t FROM Transaction t WHERE t.book.id = :bookId AND t.reader.id = :readerId " +
            "AND t.date = (SELECT MAX(t.date) FROM Transaction t WHERE t.book.id = :bookId)")
    Transaction findLastTransactionByBookAndReader(UUID readerId, UUID bookId);
}
