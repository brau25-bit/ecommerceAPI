package org.example.ecommerce.domain.interfaces;

import org.example.ecommerce.domain.models.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    User findByEmail(String email);
    boolean existsByEmail(String email);
}
