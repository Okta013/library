package ru.anikeeva.test.library.payload.response;

public record AuthResponse(
        String accessToken,
        String refreshToken,
        String type
)
{
    public AuthResponse(String accessToken, String refreshToken) {
        this(accessToken, refreshToken, "Bearer");
    }
}