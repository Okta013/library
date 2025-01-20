package ru.anikeeva.test.library.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.anikeeva.test.library.entities.Employee;
import ru.anikeeva.test.library.repositories.EmployeeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        log.info("Зарузка пользователя с логином: " + login);
        Optional<Employee> employee = employeeRepository.findByLogin(login);
        if (!employee.isPresent()) {
            log.warn("Сотрудник с указанными данными не существует");
            throw new UsernameNotFoundException("Сотрудник с указанными данными не существует");
        }
        log.info("Пользователь успешно загружен");
        return UserDetailsImpl.build(employee.get());
    }
}
