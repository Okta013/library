package ru.anikeeva.test.library.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.anikeeva.test.library.entities.Author;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    @Query("SELECT a FROM Author a JOIN a.books b JOIN Transaction t ON b.id = t.book.id " +
            "WHERE t.operation = 'TAKING' AND t.date BETWEEN :startDate AND :endDate " +
            "GROUP BY a.id ORDER BY COUNT(t) DESC")
    List<Author> findMostPopularAuthors(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}