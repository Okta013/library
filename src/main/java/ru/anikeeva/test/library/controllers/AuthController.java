package ru.anikeeva.test.library.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.anikeeva.test.library.jwt.JwtUtil;
import ru.anikeeva.test.library.payload.request.LoginRequest;
import ru.anikeeva.test.library.payload.request.TokenRefreshRequest;
import ru.anikeeva.test.library.payload.response.AuthResponse;
import ru.anikeeva.test.library.services.EmployeeService;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
@Tag(name = "Авторизация сотрудника", description = "Операции по получению токенов")
public class AuthController {
    private final EmployeeService employeeService;
    private final JwtUtil jwtUtil;

    private static final long ACCESS_TOKEN_VALIDITY = 10;
    private static final long REFRESH_TOKEN_VALIDITY = 30;

    @PostMapping
    @Operation(summary = "Вход в систему", description = "Обеспечивает авторизацию и получение токена")
    public ResponseEntity<?> login(
            @RequestBody @Parameter(description = "Логин и пароль сотрудника") LoginRequest loginRequest
    )
    {
        boolean isAuthenticated = employeeService.authenticate(loginRequest.login(), loginRequest.password());

        if (!isAuthenticated) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Неверный логин или пароль");
        }

        String accessToken = jwtUtil.generateToken(loginRequest.login(), ACCESS_TOKEN_VALIDITY);
        String refreshToken = jwtUtil.generateToken(loginRequest.login(), REFRESH_TOKEN_VALIDITY);
        return ResponseEntity.ok(new AuthResponse(accessToken, refreshToken));
    }

    @PostMapping("/refresh")
    @Operation(summary = "Получение нового токена по рефреш-токену",
            description = "Позволяет получить новый токен авторизации по имеющемуся refresh-токену, если он не истек")
    public ResponseEntity<?> refresh(
            @RequestBody @Parameter(description = "Refresh-токен") TokenRefreshRequest tokenRefreshRequest
    )
    {
        String refreshToken = tokenRefreshRequest.refreshToken();

        if (jwtUtil.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Недествительный refresh токен");
        }

        String login = jwtUtil.getLoginFromJwtToken(refreshToken);
        String newAccessToken = jwtUtil.generateToken(login, ACCESS_TOKEN_VALIDITY);
        return ResponseEntity.ok(new AuthResponse(newAccessToken, refreshToken));
    }
}
