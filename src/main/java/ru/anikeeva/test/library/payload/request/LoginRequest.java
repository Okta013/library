package ru.anikeeva.test.library.payload.request;

public record LoginRequest(
        String login,
        String password
) {
}
