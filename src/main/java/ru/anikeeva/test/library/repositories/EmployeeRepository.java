package ru.anikeeva.test.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anikeeva.test.library.entities.Employee;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Optional<Employee> findByLogin(String login);
}