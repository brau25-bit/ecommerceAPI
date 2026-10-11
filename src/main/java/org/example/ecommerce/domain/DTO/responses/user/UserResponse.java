package org.example.ecommerce.domain.DTO.responses.user;

import java.time.Instant;

public record UserResponse(
        String id,
        String name,
        String lastName,
        int age,
        String email,
        Instant createdAt
) {}
