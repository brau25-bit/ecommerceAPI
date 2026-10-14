package org.example.ecommerce.domain.DTO.responses.user;

import java.time.Instant;

public record LoginResponse(
        String accessToken,
        Instant tokenType,
        Instant expiresIn
) {
}
