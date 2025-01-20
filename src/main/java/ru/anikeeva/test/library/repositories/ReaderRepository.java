package ru.anikeeva.test.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.anikeeva.test.library.entities.Reader;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, UUID> {
    @Query(value = "SELECT r.* FROM readers r JOIN transactions t ON t.reader_id = r.id " +
            "WHERE t.operation = 'TAKING' GROUP BY r.id ORDER BY count(*) DESC LIMIT 1", nativeQuery = true)
    Reader findMostReadingReader();

    @Query(value = "SELECT r.*, " +
            "SUM(CASE WHEN t.operation = 'TAKING' THEN 1 ELSE 0 END) AS taking_count, " +
            "SUM(CASE WHEN t.operation = 'RETURNING' THEN 1 ELSE 0 END) AS returning_count " +
            "FROM readers r " +
            "LEFT JOIN transactions t ON r.id = t.reader_id " +
            "GROUP BY r.id " +
            "ORDER BY (SUM(CASE WHEN t.operation = 'TAKING' THEN 1 ELSE 0 END) - " +
            "SUM(CASE WHEN t.operation = 'RETURNING' THEN 1 ELSE 0 END)) DESC",
            nativeQuery = true)
    List<Reader> findDebtors();
}