package org.example.ecommerce.domain.DTO.responses.error;

import java.time.Instant;
import java.util.Map;

public record ExceptionResponse(
        int statusCode,
        String message,
        Instant timestamp,
        Map<String, String> errors
) {}
