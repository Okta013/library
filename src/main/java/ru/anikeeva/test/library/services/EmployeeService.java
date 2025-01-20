package ru.anikeeva.test.library.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.anikeeva.test.library.entities.Employee;
import ru.anikeeva.test.library.repositories.EmployeeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<Employee> findByLogin(String login) {
        return employeeRepository.findByLogin(login);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean authenticate(String login, String password) {
        Optional<Employee> employeeOpt = findByLogin(login);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            return passwordEncoder.matches(password, employee.getPassword());
        }
        return false;
    }

    public Employee registerEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }
}
