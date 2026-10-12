package org.example.ecommerce.application.command;

import java.time.Instant;

public record CreateUserCommand(
        String name,
        String lastName,
        Integer age,
        String email,
        String password
) {}
