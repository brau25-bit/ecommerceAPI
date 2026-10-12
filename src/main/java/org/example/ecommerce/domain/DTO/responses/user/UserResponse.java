package org.example.ecommerce.domain.DTO.responses.user;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String name,
        String lastName,
        int age,
        String email,
        Instant createdAt
) {}
