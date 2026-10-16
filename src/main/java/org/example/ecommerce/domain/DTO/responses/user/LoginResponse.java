package org.example.ecommerce.domain.DTO.responses.user;

import java.time.Instant;
import java.util.Date;

public record LoginResponse(
        String accessToken,
        Date expiresIn
) {
}
