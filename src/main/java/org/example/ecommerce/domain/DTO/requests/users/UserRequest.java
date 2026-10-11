package org.example.ecommerce.domain.DTO.requests.users;

import jakarta.validation.constraints.*;

public record UserRequest(
        @NotBlank String name,
        @NotBlank String lastName,
        @NotNull @Min(18) @Max(99) Integer age,
        @NotBlank @Email String email,
        @NotBlank @Size(min=8, max=255) String password
) {}
